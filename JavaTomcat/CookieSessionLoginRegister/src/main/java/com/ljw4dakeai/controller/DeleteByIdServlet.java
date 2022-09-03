package com.ljw4dakeai.controller;

import com.ljw4dakeai.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * @description: 删除的servlet
 * @title: DeleteByIdServlet
 * @package com.ljw4dakeai.com.ljw4dakeai.controller
 * @date 2022/8/27 7:43 下午
 * @author ljw4dakeai
 */
@WebServlet("/deleteByIdServlet")
public class DeleteByIdServlet extends HttpServlet {
    private final BrandService brandService = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Integer integer = brandService.deleteBrandById(id);
        System.out.println(integer + "行受影响!");
        response.sendRedirect(request.getContextPath() + "/selectAllServlet");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
