package com.domhelper.web.servlet.doorLadyServlet;

import com.domhelper.service.DoorladyService;
import com.domhelper.service.impl.DoorladyServiceImpl;
import com.domhelper.utils.ResponseFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: xuefrye
 * @Date: 2019/4/21 16:39
 * @Version: 1.0
 * @File: CancelProveDoorladyServlet
 * @Description:
 */
@WebServlet("/CancelProveDoorladyServlet")
public class CancelProveDoorladyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);

        // 设置响应头
        response.setHeader("Content-Type", "application/json;charset=utf-8;");
        response.setHeader("Allow", "POST");
        //获取宿管id
        String id = request.getParameter("doorlady_id");   //id
        if (id == null || "".equals(id)) {
            response.getWriter().append("宿管id参数错误！");
            return;
        }

        //数据库访问
        //TODO 添加异常处理
        DoorladyService service = new DoorladyServiceImpl();
        int result = service.cancelProveById(Integer.parseInt(id));

        if (result != 0) {
            String res = ResponseFormat.resFormat("200", "取消宿管认证成功", null);
            response.getWriter().append(res);
        } else {
            String res = ResponseFormat.resFormat("500", "取消宿管认证失败", null);
            response.getWriter().append(res);
        }
    }
}
