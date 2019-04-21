package com.domhelper.web.servlet.adminServlet;

import com.alibaba.fastjson.JSONArray;
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
import java.util.List;

/**
 * @Author: xuefrye
 * @Date: 2019/4/20 18:11
 * @Version: 1.0
 * @File: GetAdminListServlet
 * @Description:
 */
@WebServlet("/GetAdminListServlet")
public class GetAdminListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应头
        response.setHeader("Content-Type", "application/json;charset=utf-8;");
        response.setHeader("Allow", "GET");
        /* 允许跨域的主机地址 */
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* 重新预检验跨域的缓存时间 (s) */
        response.setHeader("Access-Control-Max-Age", "3600");
        /* 是否携带cookie */
        response.setHeader("Access-Control-Allow-Credentials", "true");
        //初始化数据库连接

/*TODO		检查登录态
        if(!AdminSafe.CheckSession(request, response)) {
            return;
        }*/

        //数据库查询
        AdminService service = new AdminServiceImpl();
        List<Admin> adminList = service.findAll();

        JSONArray adminArray = new JSONArray();

        for (Admin admin : adminList) {
            adminArray.add(admin.toJSONObject());
        }

        String res = ResponseFormat.resFormat("200", "管理员列表查询成功", adminArray);
        response.getWriter().append(res);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
