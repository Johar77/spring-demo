package com.johar.test.pf4japi;

import org.pf4j.DefaultPluginManager;
import org.pf4j.JarPluginManager;
import org.pf4j.PluginManager;

import java.nio.file.Paths;
import java.util.List;

/**
 * @author : [johar]
 * @description : [一句话描述该类的功能]
 * @createTime : [2025/10/2 14:12]
 * @updateUser : [johar]
 * @updateTime : [2025/10/2 14:12]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class App {

    public static void main(String[] args) {
        // 创建插件管理器
        PluginManager pluginManager = new DefaultPluginManager();

        //pluginManager.loadPlugin(Paths.get("E:\\Java\\workspace\\spring-demo\\pf4j-api\\target\\pf4j-api-0.0.1-SNAPSHOT.jar"));
        // 启动并加载应用程序的所有插件
        pluginManager.loadPlugins();
        pluginManager.startPlugins();

        // 检索 "Greeting" 扩展点的所有扩展
        List<Greeting> greetings = pluginManager.getExtensions(Greeting.class);
        for (Greeting greeting : greetings) {
            System.out.println(">>> " + greeting.greet());
        }

        // 停止并卸载所有插件
        pluginManager.stopPlugins();
        pluginManager.unloadPlugins();
    }
}
