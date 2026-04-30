package com.johar.test.agentscopedemo.tool;

import io.agentscope.core.tool.Tool;

/**
 * @author : [johar]
 * @description : [一句话描述该类的功能]
 * @createTime : [2026/3/29 10:56]
 * @updateUser : [johar]
 * @updateTime : [2026/3/29 10:56]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class ProjectManagementTools {

    @Tool(description = "分析项目需求")
    public String analyzeRequirements(String projectName, String description) {
        return "需求分析完成：\n" +
                "- 功能需求：3个核心功能\n" +
                "- 非功能需求：性能、安全、可维护性\n" +
                "- 技术栈：Java、Spring Boot、Redis";
    }

    @Tool(description = "分配开发资源")
    public String allocateResources(String taskName, int devCount, String skills) {
        return "资源分配完成：" +
                "\n- 开发人员：" + devCount + "人\n" +
                "- 技能要求：" + skills;
    }

    @Tool(description = "评估风险")
    public String assessRisks(String taskName) {
        return "风险评估完成：\n" +
                "- 高风险：1项\n" +
                "- 中风险：2项\n" +
                "- 低风险：3项";
    }
}
