package com.johar.test.liteflowtest.component;

import cn.hutool.core.collection.ListUtil;
import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeIteratorComponent;

import java.util.Iterator;
import java.util.List;

/**
 * @author : [johar]
 * @description : [一句话描述该类的功能]
 * @createTime : [2025/12/9 23:52]
 * @updateUser : [johar]
 * @updateTime : [2025/12/9 23:52]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
@LiteflowComponent("x")
public class XCmp extends NodeIteratorComponent {

    @Override
    public Iterator<?> processIterator() throws Exception {
        List<String> list = ListUtil.toList("jack", "mary", "tom");
        return list.iterator();
    }


}
