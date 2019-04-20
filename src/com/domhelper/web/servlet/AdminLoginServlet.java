package com.domhelper.web.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.domhelper.bean.Admin;
import com.domhelper.service.AdminService;
import com.domhelper.service.impl.AdminServiceImpl;
import com.domhelper.utils.ResponseFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author: xuefrye
 * @Date: 2019/4/20 10:09
 * @Version: 1.0
 * @File: ${NAME}
 * @Description:
 */
@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应头
        response.setHeader("Content-Type", "application/json;charset=utf8");
        /* 允许跨域的主机地址 */
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* 允许跨域的请求方法GET, POST, HEAD 等 */
        response.setHeader("Access-Control-Allow-Methods", "POST");
        /* 重新预检验跨域的缓存时间 (s) */
        response.setHeader("Access-Control-Max-Age", "3600");
        /* 是否携带cookie */
        response.setHeader("Access-Control-Allow-Credentials", "true");
        //获取登录参数
        String admin_name = request.getParameter("admin_name");   //名
        String password = request.getParameter("admin_password");    //密码
        HttpSession session = request.getSession();
        if (admin_name == null || password == null) {
            response.getWriter().append("管理员登陆失败");
            return;
        }

        //登录服务
        AdminService service = new AdminServiceImpl();
        Admin loginAdmin = service.login(admin_name, password);


        if (loginAdmin != null) {
            //登录成功
            session.setAttribute("session", loginAdmin.getAdminId());

            JSONObject data = JSON.parseObject(loginAdmin.toJSONString());
            JSONArray dataArray = new JSONArray();
            dataArray.add(data);

            String res = ResponseFormat.resFormat("200", "管理员登陆成功", dataArray);
            response.getWriter().append(res);
        } else {
            //登录失败
            String res = ResponseFormat.resFormat("500", "管理员登陆失败", null);
            response.getWriter().append(res);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Content-Type", "application/json;charset=utf8");
        response.getWriter().append("请求方式错误！");
    }
}
