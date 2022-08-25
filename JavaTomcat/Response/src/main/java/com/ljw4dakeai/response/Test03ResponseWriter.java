package com.ljw4dakeai.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ljw4dakeai
 * @description: 响应写字符流
 * @title: Test03ResponseWriter
 * @package com.ljw4dakeai.response
 * @date 2022/8/25 15:15
 */
@WebServlet("/testResponseWriter")
public class Test03ResponseWriter extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        //原始方法
//        resp.setCharacterEncoding("utf-8");
//        resp.setHeader("content-type", "text/html;charset=utf-8");

        //合并方法
        //默认写在第一行
        resp.setContentType("text/html;charset=utf-8");

        resp.getWriter().write(97); //底层将int转化为char型 输出a
        resp.getWriter().print(97); //底层通过string.valueOf包装 输出97


        //响应html
        resp.getWriter().print("\n" +
                "<table border=\"1\" width=\"100%\" cellspacing=\"0\">\n" +
                "    <tr>\n" +
                "        <th colspan=\"2\"></th>\n" +
                "        <th>星期一</th>\n" +
                "        <th>星期二</th>\n" +
                "        <th>星期三</th>\n" +
                "        <th>星期四</th>\n" +
                "        <th>星期五</th>\n" +
                "    </tr>\n" +
                "\n" +
                "    <tr align=\"center\" >\n" +
                "        <td rowspan=\"4\">上午</td>\n" +
                "        <td>早自习</td>\n" +
                "        <td>英语</td>\n" +
                "        <td>语文</td>\n" +
                "        <td>英语</td>\n" +
                "        <td>语文</td>\n" +
                "        <td>英语</td>\n" +
                "    </tr>\n" +
                "    <tr align=\"center\">\n" +
                "        <td>第1节</td>\n" +
                "        <td>数学</td>\n" +
                "        <td>数学</td>\n" +
                "        <td>数学</td>\n" +
                "        <td>数学</td>\n" +
                "        <td>数学</td>\n" +
                "    </tr>\n" +
                "    <tr align=\"center\">\n" +
                "        <td>第2节</td>\n" +
                "        <td>物理</td>\n" +
                "        <td>物理</td>\n" +
                "        <td>物理</td>\n" +
                "        <td>物理</td>\n" +
                "        <td>物理</td>\n" +
                "    </tr>\n" +
                "    <tr align=\"center\">\n" +
                "        <td>第3节</td>\n" +
                "        <td>化学</td>\n" +
                "        <td>化学</td>\n" +
                "        <td>化学</td>\n" +
                "        <td>化学</td>\n" +
                "        <td>化学</td>\n" +
                "    </tr>\n" +
                "    <tr align=\"center\" >\n" +
                "        <td colspan=\"7\">午休</td>\n" +
                "    </tr>\n" +
                "    <tr align=\"center\">\n" +
                "        <td rowspan=\"3\">下午</td>\n" +
                "        <td>第4节</td>\n" +
                "        <td>生物</td>\n" +
                "        <td>生物</td>\n" +
                "        <td>生物</td>\n" +
                "        <td>生物</td>\n" +
                "        <td>生物</td>\n" +
                "    </tr>\n" +
                "    <tr align=\"center\">\n" +
                "        <td>第5节</td>\n" +
                "        <td>英语</td>\n" +
                "        <td>英语</td>\n" +
                "        <td>英语</td>\n" +
                "        <td>英语</td>\n" +
                "        <td>英语</td>\n" +
                "    </tr>\n" +
                "    <tr align=\"center\">\n" +
                "        <td>第6节</td>\n" +
                "        <td>语文</td>\n" +
                "        <td>语文</td>\n" +
                "        <td>语文</td>\n" +
                "        <td>语文</td>\n" +
                "        <td>语文</td>\n" +
                "    </tr>\n" +
                "</table>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
