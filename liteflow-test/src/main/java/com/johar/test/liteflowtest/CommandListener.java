package com.johar.test.liteflowtest;


import com.yomahub.liteflow.core.FlowExecutor;
import com.yomahub.liteflow.flow.LiteflowResponse;
import com.yomahub.liteflow.slot.DefaultContext;
import jakarta.annotation.Resource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author : [johar]
 * @description : [一句话描述该类的功能]
 * @createTime : [2025/10/2 15:15]
 * @updateUser : [johar]
 * @updateTime : [2025/10/2 15:15]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
@Component
public class CommandListener implements CommandLineRunner {

    @Resource
    private FlowExecutor flowExecutor;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("CommandListener.run");
        LiteflowResponse response = flowExecutor.execute2Resp("chain4", "arg", DefaultContext.class);
        System.out.println(response);

//        LiteflowResponse response2 = flowExecutor.execute2Resp("chain2", "arg", DefaultContext.class);
//        System.out.println(response2);
    }
}
