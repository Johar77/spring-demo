package com.johar.test.easyruletest.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.enums.WriteDirectionEnum;
import com.alibaba.excel.util.MapUtils;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.fill.FillConfig;
import com.alibaba.excel.write.metadata.fill.FillWrapper;
import org.apache.commons.compress.utils.Lists;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

public class EasyExcelTest {


    public static void main(String[] args) {

        //ConcurrentLinkedQueue queue = new ConcurrentLinkedQueue();





        String templateFileName = "E:\\common\\模板.xlsx";

        // 方案1 一下子全部放到内存里面 并填充
//        String fileName = "E:\\common\\文件.xlsx";;
//        Map<String, Object> map = MapUtils.newHashMap();
//        map.put("name", "张三");
//        map.put("age", 33);
//        map.put("sex", "男");
//        // 这里 会填充到第一个sheet， 然后文件流会自动关闭
//        EasyExcel.write(fileName).withTemplate(templateFileName).sheet().doFill(map);


        String fileName = "E:\\common\\文件.xlsx";;
        Map<String, Object> map1 = MapUtils.newHashMap();
        map1.put("name", "张三1");
        map1.put("age", 33);
        map1.put("sex", "男1");
        Map<String, Object> map2 = MapUtils.newHashMap();
        map2.put("name", "张三2");
        map2.put("age", 34);
        map2.put("sex", "男2");
        List<Map<String, Object>> mapList = Lists.newArrayList();
        mapList.add(map1);
        mapList.add(map2);


        Map<String, Object> ageMap1 = MapUtils.newHashMap();
        ageMap1.put("sex", "男1");
        Map<String, Object> ageMap2 = MapUtils.newHashMap();
        ageMap2.put("sex", "男2");
        Map<String, Object> ageMap3 = MapUtils.newHashMap();
        ageMap3.put("sex", "男3");
        List<Map<String, Object>> ageMapList = Lists.newArrayList();
        ageMapList.add(ageMap1);
        ageMapList.add(ageMap2);
        ageMapList.add(ageMap3);

        try (ExcelWriter excelWriter = EasyExcel.write(fileName).withTemplate(templateFileName).build()) {
            WriteSheet writeSheet = EasyExcel.writerSheet().build();
            //FillConfig fillConfig = FillConfig.builder().direction(WriteDirectionEnum.HORIZONTAL).build();
            // 如果有多个list 模板上必须有{前缀.} 这里的前缀就是 data1，然后多个list必须用 FillWrapper包裹
            excelWriter.fill(new FillWrapper("data1", mapList), writeSheet);
            excelWriter.fill(new FillWrapper("data2", ageMapList), writeSheet);

        }
    }
}
