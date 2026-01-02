package com.johar.test.liteflowtest.component;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;
import com.yomahub.liteflow.slot.DefaultContext;

/**
 * @author : [johar]
 * @description : [一句话描述该类的功能]
 * @createTime : [2025/12/17 0:12]
 * @updateUser : [johar]
 * @updateTime : [2025/12/17 0:12]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
@LiteflowComponent("g")
public class GCmp extends NodeComponent {

    @Override
    public void process() throws Exception {
        Thread.sleep(1000*2);
        DefaultContext defaultContext = this.getContextBean(DefaultContext.class);
        defaultContext.setData("g", "g");
        System.out.println(this.getCurrChainId() + ":defaultContext: " + defaultContext.getDataMap());
        System.out.println(this.getCurrChainId() + ":GCmp executed");
    }
}
