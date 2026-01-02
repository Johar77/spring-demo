package com.johar.test.liteflowtest.component;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;
import com.yomahub.liteflow.slot.DefaultContext;

/**
 * @author : [johar]
 * @description : [一句话描述该类的功能]
 * @createTime : [2025/12/17 23:21]
 * @updateUser : [johar]
 * @updateTime : [2025/12/17 23:21]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
@LiteflowComponent("s1")
public class S1Cmp extends NodeComponent {

    @Override
    public void process() throws Exception {
        Thread.sleep(1000*3);
        DefaultContext defaultContext = this.getContextBean(DefaultContext.class);
        defaultContext.setData("s1", "s1");
        System.out.println(this.getCurrChainId() + ":defaultContext: " + defaultContext.getDataMap());
        System.out.println(this.getCurrChainId() + ":S1Cmp executed");
    }
}
