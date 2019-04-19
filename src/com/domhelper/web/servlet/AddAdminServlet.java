package com.domhelper.web.servlet;

import com.domhelper.bean.Admin;
import com.domhelper.service.AdminService;
import com.domhelper.service.impl.AdminServiceImpl;
import com.domhelper.utils.ResponseFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: xuefrye
 * @Date: 2019/4/19 22:04
 * @Version: 1.0
 * @File: AddAdminServlet
 * @Description:
 */
@WebServlet("/AddAdminServlet")
public class AddAdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Content-Type", "application/json;charset=utf-8;");
        response.setHeader("Allow", "GET");
        response.setHeader("Access-Control-Allow-Origin", "*");

        //TODO 登录验证

        //************

        String adminName = request.getParameter("adminName");
        String adminPassword = request.getParameter("adminPassword");
        String realName = request.getParameter("relName");

        if(adminName==null||adminPassword==null||realName==null) {
            String rs=ResponseFormat.resFormat("501", "�����������", null);
            response.getWriter().append(rs);
            return;
        }

        Admin admin = new Admin();
        admin.setAdminName(adminName);
        admin.setAdminPassword(adminPassword);
        admin.setRealName(realName);

        AdminService service = new AdminServiceImpl();

        int result = service.add(admin);

        if (result > 0) {
            String res = ResponseFormat.resFormat("200", "管理员添加成功", null);
            response.getWriter().append(res);
        } else {
            String res = ResponseFormat.resFormat("500", "管理员添加失败", null);
            response.getWriter().append(res);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO 修改乱码
        String rs = ResponseFormat.resFormat("502", "����ʽ����", null);
        response.getWriter().append(rs);
    }
}
