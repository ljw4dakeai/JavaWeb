package com.ljw4dakeai.controller;

import com.ljw4dakeai.pojo.Brand;
import com.ljw4dakeai.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

/**
 * 处理查询所有的请求
 */
@WebServlet("/selectAllServlet")
public class SelectAllServlet extends HttpServlet {

    private final BrandService brandService = new BrandService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("brands", brandService.SelectAllBrand());
        request.getRequestDispatcher("/filter/brand.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
