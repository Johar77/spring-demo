package com.johar.test.liteflowtest.component;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;
import com.yomahub.liteflow.slot.DefaultContext;

/**
 * @author : [johar]
 * @description : [一句话描述该类的功能]
 * @createTime : [2025/12/17 0:06]
 * @updateUser : [johar]
 * @updateTime : [2025/12/17 0:06]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
@LiteflowComponent("d")
public class DCmp extends NodeComponent {

    public void process() throws Exception {
        Thread.sleep(1000*9);
        DefaultContext defaultContext = this.getContextBean(DefaultContext.class);
        defaultContext.setData("d", "d");
        System.out.println(this.getCurrChainId() + ":defaultContext: " + defaultContext.getDataMap());
        System.out.println(this.getCurrChainId() + ":DCmp executed");
    }
}
