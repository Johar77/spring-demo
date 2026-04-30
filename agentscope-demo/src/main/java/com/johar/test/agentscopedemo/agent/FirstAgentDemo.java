package com.johar.test.agentscopedemo.agent;

import com.johar.test.agentscopedemo.hook.LoggingHook;
import com.johar.test.agentscopedemo.tool.SimpleTools;
import io.agentscope.core.ReActAgent;
import io.agentscope.core.hook.Hook;
import io.agentscope.core.message.Msg;
import io.agentscope.core.model.DashScopeChatModel;
import io.agentscope.core.studio.StudioManager;
import io.agentscope.core.studio.StudioMessageHook;
import io.agentscope.core.tool.Toolkit;

import java.util.List;

/**
 * @author : [johar]
 * @description : [一句话描述该类的功能]
 * @createTime : [2026/3/28 16:57]
 * @updateUser : [johar]
 * @updateTime : [2026/3/28 16:57]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class FirstAgentDemo {

    public static void main(String[] args) {
        // 初始化 Studio 连接
        StudioManager.init()
                .studioUrl("http://localhost:3000")
                .project("MyProject")
                .runName("demo_" + System.currentTimeMillis())
                .initialize()
                .block();

        Toolkit toolkit = new Toolkit();
        toolkit.registerTool(new SimpleTools());
        Hook studioMessageHook = new StudioMessageHook(StudioManager.getClient());
        Hook loggingHook = new LoggingHook();
        // 创建智能体并内联配置模型
        ReActAgent agent = ReActAgent.builder()
                .name("Assistant")
                .sysPrompt("你是一个有帮助的 AI 助手。")
                .toolkit(toolkit)
                .model(DashScopeChatModel.builder()
                        .apiKey(System.getenv("DASHSCOPE_API_KEY"))
                        .modelName("qwen3-max")
                        .stream( true)
                        .enableThinking( true)
                        .build())
                .hooks(List.of(studioMessageHook, loggingHook))
                .build();

        Msg response = agent.call(Msg.builder()
                .textContent("请问一下现在时间？天气怎么样？")
                .build()).block();
        System.out.println(response.getTextContent());

        // 关闭 Studio
        StudioManager.shutdown();
    }
}
