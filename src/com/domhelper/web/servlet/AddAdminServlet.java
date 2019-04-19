package com.domhelper.web.servlet;

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
        String adminName=request.getParameter("adminName");
        String adminPassword=request.getParameter("adminPassword");
        String relName=request.getParameter("relName");

        //TODO 登录验证

        //************


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO 修改乱码
        String rs= ResponseFormat.resFormat("502", "����ʽ����", null);
        response.getWriter().append(rs);
    }
}
