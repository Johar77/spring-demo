package com.johar.test.liteflowtest.component;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;

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
public class Acmp extends NodeComponent {
    @Override
    public void process() throws Exception {
        System.out.println("a组件执行");
    }
}
