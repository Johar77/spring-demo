package com.johar.test.liteflowtest.component;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;

/**
 * @author : [johar]
 * @description : [一句话描述该类的功能]
 * @createTime : [2025/10/2 15:12]
 * @updateUser : [johar]
 * @updateTime : [2025/10/2 15:12]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
@LiteflowComponent("c")
public class CCmp extends NodeComponent {
    @Override
    public void process() throws Exception {
        System.out.println("CCmp executed");
    }
}
