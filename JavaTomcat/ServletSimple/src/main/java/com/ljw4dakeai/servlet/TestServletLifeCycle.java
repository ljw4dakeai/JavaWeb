package com.ljw4dakeai.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @author ljw4dakeai
 * @description: 测试Servlet生命周期
 * @title: TestServletLifeCycle
 * @package com.ljw4dakeai.servlet
 * @date 2022/8/24 15:03
 */

@WebServlet(value = "/testServletLifeCycle", loadOnStartup = 1)//配置loadOnStartup = 1配置启动时加载, 初始化对象, 加载配置文件
public class TestServletLifeCycle implements Servlet {
    /**
     * 阶段一 :  实例化阶段
     * 执行时机  : 第一次访问时执行
     * 执行次数  : 一次
     * 作用  :  初始化对象
     */
    public TestServletLifeCycle() {
        System.out.println("实例化阶段!");
        System.out.println("---------------------------------------");
    }


    /**
     * 阶段二 :  实例化阶段
     * 执行时机  : 默认情况下第一次访问实例化之后
     * 执行次数  : 一次
     * 作用  :  初始化该类需要的数据, 加载配置文件, 加载框架配置文件
     */
    private ServletConfig servletConfig;
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig = servletConfig;
        System.out.println("初始化阶段!");
        System.out.println("---------------------------------------");
    }

    /**
     * @return  包含了Servlet初始化和启动参数,返回对象是给init()的
     */
    @Override
    public ServletConfig getServletConfig() {
        return servletConfig;
    }

    /**
     * 阶段三 :  请求处理(服务)阶段
     * 执行时机  : 每次请求都执行
     * 执行次数  : 多次
     * 作用  :  处理请求,获取请求中的数据,
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("请求处理(服务)阶段!");
        System.out.println("---------------------------------------");
    }

    /**
     * 阶段四 :  销毁阶段
     * 执行时机  : 服务器关闭, 或者项目从服务器中移除
     * 执行次数  : 一次
     * 作用  :  释放资源
     */
    @Override
    public void destroy() {
        System.out.println("销毁阶段!");
    }

    /**
     * @return 返回Servlet版本, 版权, 作者
     */
    @Override
    public String getServletInfo() {
        return "@author : ljw4dakeai" +
                "@version : v1.0";
    }

}
