package com.ljw4dakeai.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
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
 * @description: 批量删除
 * @title: DeleteByIdsServlet
 * @package com.ljw4dakeai.controller
 * @date 2022/9/1 4:17 下午
 */


@WebServlet("/deleteByIdsServlet")
public class DeleteByIdsServlet extends HttpServlet {
    private final BrandService brandService = new BrandServiceImpl();
    private final ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int[] ints = objectMapper.readValue(request.getReader(), int[].class);
        boolean successIf = brandService.deleteByIds(ints);
        response.getWriter().write(successIf ? "success" : "filed");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
