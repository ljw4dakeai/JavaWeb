package com.ljw4dakeai.servlet;

import com.ljw4dakeai.pojo.Brand;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ljw4dakeai
 * @description: servlet中保存数据
 * @title: BrandServlet
 * @package com.ljw4dakeai.servlet
 * @date 2022/8/27 1:48 下午
 */
@WebServlet("/brandServlet")
public class BrandServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1 准备数据(模拟)，将来需要使用mybatis访问数据库，获取数据
        List<Brand> brands = new ArrayList<Brand>();
        brands.add(new Brand(1,"三只松鼠","三只松鼠",100,"三只松鼠，好吃不上火",1));
        brands.add(new Brand(2,"优衣库","优衣库",200,"优衣库，服适人生",0));
        brands.add(new Brand(3,"小米","小米科技有限公司",1000,"为发烧而生",1));
        //2 将数据保存到request域对象中
        request.setAttribute("list",brands);
        //3 请求转发到jsp页面获取数据
        request.getRequestDispatcher("/jstl/jstl_forEach.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
