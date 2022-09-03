package com.ljw4dakeai.controller;


import com.ljw4dakeai.pojo.Brand;
import com.ljw4dakeai.service.BrandService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * 处理添加品牌信息请求
 */
@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {
    private final BrandService brandService = new BrandService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //解决写入中文乱码
        request.setCharacterEncoding("utf-8");

        //获取请求参数,封装为一个对象
        Brand brand = new Brand();
        try {
            BeanUtils.populate(brand, request.getParameterMap());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        brandService.add(brand);

        response.sendRedirect(request.getContextPath() + "/selectAllServlet");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
