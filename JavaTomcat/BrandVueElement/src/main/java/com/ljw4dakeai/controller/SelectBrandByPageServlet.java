package com.ljw4dakeai.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.ljw4dakeai.pojo.Brand;
import com.ljw4dakeai.service.BrandService;
import com.ljw4dakeai.service.impl.BrandServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @author ljw4dakeai
 * @description: 分页查询servlet
 * @title: SelectBrandByPageServlet
 * @package com.ljw4dakeai.controller
 * @date 2022/9/1 9:59 上午
 */


@WebServlet("/selectBrandByPageServlet")
public class SelectBrandByPageServlet extends HttpServlet {
    //多态实现解耦,以后会交给Spring使用@AutoWride实现解耦
    private final BrandService brandService = new BrandServiceImpl();
    private final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 分页查询显示层, 对请求的两个参数胡进行分页查询
     *
     * @param request  请求
     * @param response 响应
     * @throws IOException io异常
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        int currentPage = 0;
        int pageSize = 0;
        Brand brand = null;
        try {
            currentPage = Integer.parseInt(request.getParameter("currentPage"));
            pageSize = Integer.parseInt(request.getParameter("pageSize"));
            brand = objectMapper.readValue(request.getReader(), Brand.class);
            System.out.println(brand);
        } catch (Exception e) {
            e.printStackTrace();
        }
        PageInfo<Brand> brandPageInfo = brandService.selectBrandByPage(currentPage, pageSize, brand);
        objectMapper.writeValue(response.getWriter(), brandPageInfo);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
