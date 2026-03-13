package com.johar.mybatis.mybatistest.common;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.ClientAbortException;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author : [johar]
 * @description : [一句话描述该类的功能]
 * @createTime : [2026/1/6 23:58]
 * @updateUser : [johar]
 * @updateTime : [2026/1/6 23:58]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
@Slf4j
public class ExceptionAwareResponseWrapper extends HttpServletResponseWrapper {

    private Throwable writeThrowable; // 捕获所有Throwable（包括Error）
    private boolean hasWriteError = false;
    private final HttpServletRequest request; // 注入Request，方便日志排查

    public ExceptionAwareResponseWrapper(HttpServletRequest request, HttpServletResponse response) {
        super(response);
        this.request = request;
    }

    // 覆盖字符流（普通接口核心）
    @Override
    public PrintWriter getWriter() throws IOException {
        PrintWriter originalWriter = super.getWriter();
        return new PrintWriter(originalWriter) {
            @SneakyThrows
            @Override
            public void write(String s) {
                try {
                    super.write(s);
                    // 关键1：刷新SpringMVC编码缓冲
                    super.flush();
                    // 关键2：强制刷新Tomcat底层OutputBuffer（核心！）
                    getResponse().flushBuffer();
                } catch (Throwable t) { // 捕获所有Throwable，包括Error
                    recordThrowable(t);
                    // 抛出异常，让Tomcat能感知到（否则会被吞掉）
                    if (t instanceof RuntimeException) {
                        throw (RuntimeException) t;
                    } else if (t instanceof IOException) {
                        throw (IOException) t;
                    } else {
                        throw new RuntimeException("响应写入失败", t);
                    }
                }
            }

            // 覆盖close方法，确保最后刷新
            @Override
            public void close() {
                try {
                    super.close();
                    getResponse().flushBuffer();
                } catch (Throwable t) {
                    recordThrowable(t);
                }
            }
        };
    }

    // 覆盖字节流（二进制响应核心）
    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        ServletOutputStream originalOs = super.getOutputStream();
        return new ServletOutputStream() {
            @Override
            public boolean isReady() {
                return originalOs.isReady();
            }

            @Override
            public void setWriteListener(WriteListener listener) {
                originalOs.setWriteListener(listener);
            }

            @Override
            public void write(int b) throws IOException {
                try {
                    originalOs.write(b);
                    originalOs.flush();
                    getResponse().flushBuffer();
                } catch (Throwable t) {
                    recordThrowable(t);
                    throw new IOException("字节流写入失败", t);
                }
            }

            @Override
            public void flush() throws IOException {
                try {
                    originalOs.flush();
                    getResponse().flushBuffer();
                } catch (Throwable t) {
                    recordThrowable(t);
                    throw new IOException("字节流刷新失败", t);
                }
            }
        };
    }

    // 强制刷新缓冲的公共方法（兜底）
    @Override
    public void flushBuffer() throws IOException {
        try {
            super.flushBuffer();
        } catch (Throwable t) {
            recordThrowable(t);
            throw new IOException("强制刷新缓冲失败", t);
        }
    }

    // 记录异常（包含完整上下文）
    void recordThrowable(Throwable t) {
        this.writeThrowable = t;
        this.hasWriteError = true;
        // 提前打印日志，方便排查（避免拦截器拿不到）
        log.error("[响应写入异常] 请求URL：{}，客户端IP：{}，异常栈：{}",
                request.getRequestURI(),
                request.getRemoteAddr(),
                getStackTrace(t));
        // 标记为ClientAbortException（方便拦截器识别）
        if (t instanceof ClientAbortException ||
                (t.getCause() != null && t.getCause() instanceof ClientAbortException)) {
            this.writeThrowable = new ClientAbortException("客户端主动断开连接：" + t.getMessage(), t);
        }
    }

    // 工具方法：获取完整异常栈
    private String getStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        t.printStackTrace(new PrintWriter(sw));
        return sw.toString();
    }

    // 对外提供获取异常的方法
    public boolean hasWriteError() {
        return hasWriteError;
    }

    public Throwable getWriteThrowable() {
        return writeThrowable;
    }
}
