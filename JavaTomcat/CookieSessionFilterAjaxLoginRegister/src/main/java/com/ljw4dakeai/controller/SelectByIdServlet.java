package com.ljw4dakeai.controller;

import com.ljw4dakeai.pojo.Brand;
import com.ljw4dakeai.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 处理根据id查询品牌信息的请求
 */
@WebServlet("/selectByIdServlet")
public class SelectByIdServlet extends HttpServlet {
    private final BrandService brandService = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("brand",  brandService.selectBrandById(id));
        request.getRequestDispatcher("/filter/update.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
