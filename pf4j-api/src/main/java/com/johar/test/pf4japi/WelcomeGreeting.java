package com.johar.test.pf4japi;

/**
 * @author : [johar]
 * @description : [一句话描述该类的功能]
 * @createTime : [2025/10/2 14:06]
 * @updateUser : [johar]
 * @updateTime : [2025/10/2 14:06]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class WelcomeGreeting implements Greeting {
    @Override
    public String greet() {
        return "Welcome";
    }
}
