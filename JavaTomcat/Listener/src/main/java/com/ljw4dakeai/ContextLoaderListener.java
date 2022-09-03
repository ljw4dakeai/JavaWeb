package com.ljw4dakeai;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author ljw4dakeai
 * @description: Application监听器
 * @title: ContextLoaderListener
 * @package com.ljw4dakeai
 * @date 2022/8/28 7:47 下午
 */
@WebListener
public class ContextLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //在服务器启动的时候运行
        System.out.println("start ContextLoaderListener - - -");
        //可以用来加载配置文件
        //信息: Starting com.ljw4dakeai.service Tomcat
        //八月 28, 2022 7:53:11 下午 org.apache.catalina.core.StandardEngine startInternal
        //信息: Starting Servlet Engine: Apache Tomcat/7.0.47
        //start ContextLoaderListener - - -
        //八月 28, 2022 7:53:14 下午 org.apache.coyote.AbstractProtocol start
        //信息: Starting ProtocolHandler ["http-bio-8080"]
        //stop ContextLoaderListener - - -
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //服务器正常退出的时候运行
        System.out.println("stop ContextLoaderListener - - -");
    }
}
