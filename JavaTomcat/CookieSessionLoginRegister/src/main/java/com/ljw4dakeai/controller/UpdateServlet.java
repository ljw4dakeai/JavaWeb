package com.ljw4dakeai.controller;

import com.ljw4dakeai.pojo.Brand;
import com.ljw4dakeai.service.BrandService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/**
 * 处理修改品牌信息的请求
 */
@WebServlet("/updateServlet")
public class UpdateServlet extends HttpServlet {
    private final BrandService brandService = new BrandService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码调整字符集集
        request.setCharacterEncoding("utf-8");
        Brand brand = new Brand();
        try {
            BeanUtils.populate(brand, request.getParameterMap());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        Integer integer = brandService.updateBrandById(brand);
        System.out.println(integer + "行受影响!");
        response.sendRedirect(request.getContextPath() + "/selectAllServlet");



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
