package com.johar.test.liteflowtest.component;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;
import com.yomahub.liteflow.slot.DefaultContext;
import lombok.extern.slf4j.Slf4j;

/**
 * @author : [johar]
 * @description : [一句话描述该类的功能]
 * @createTime : [2025/10/2 15:10]
 * @updateUser : [johar]
 * @updateTime : [2025/10/2 15:10]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
@LiteflowComponent("a")
@Slf4j
public class ACmp extends NodeComponent {
    @Override
    public void process() throws Exception {
        Thread.sleep(1000*10);
        DefaultContext defaultContext = this.getContextBean(DefaultContext.class);
        defaultContext.setData("a", "a");
        System.out.println(this.getCurrChainId() + ":defaultContext: " + defaultContext.getDataMap());
        System.out.println(this.getCurrChainId() + ":ACmp executed");
    }
}
