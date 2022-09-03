package com.ljw4dakeai.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
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
 * @description: 添加商品servlet
 * @title: AddBrandServlet
 * @package com.ljw4dakeai.controller
 * @date 2022/9/1 3:03 下午
 */

@WebServlet("/addBrandServlet")
public class AddBrandServlet extends HttpServlet {
    private final BrandService brandService = new BrandServiceImpl();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Brand brand = null;
        boolean successIf = false;
        try {
            brand = objectMapper.readValue(request.getReader(), Brand.class);
            if (brand.getBrandName().equals("") || brand.getCompanyName() == null || brand.getOrdered() == null || brand.getDescription() == null || brand.getStatus() == null) {
                response.getWriter().write("filed");
                return;
            } else {
                successIf = brandService.addBrand(brand);
            }
        } catch (Exception e) {
            response.getWriter().write("filed");
            e.printStackTrace();
        }

        response.getWriter().write(successIf ? "success" : "filed");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
