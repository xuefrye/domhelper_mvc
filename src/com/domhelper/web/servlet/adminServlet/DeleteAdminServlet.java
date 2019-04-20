package com.domhelper.web.servlet.adminServlet;

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
 * @Date: 2019/4/20 12:19
 * @Version: 1.0
 * @File: DeleteAdminServlet
 * @Description:
 */
@WebServlet("/DeleteAdminServlet")
public class DeleteAdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//设置响应头
        response.setHeader("Content-Type", "application/json;charset=utf-8;");
        response.setHeader("Allow", "GET");
        response.setHeader("Access-Control-Allow-Origin", "*");

//TODO 登录验证
//		检查登录态
//        if(!AdminSafe.CheckSession(request, response)) {
//            return;
//        }

        String adminId = request.getParameter("admin_id");
        if (adminId == null || "".equals(adminId)) {
            String res = ResponseFormat.resFormat("501", "参数错误", null);
            response.getWriter().append(res);
            return;
        }

        AdminService service = new AdminServiceImpl();
        int result = service.deleteById(Integer.parseInt(adminId));

        if (result > 0) {
            String res = ResponseFormat.resFormat("200", "管理员删除成功", null);
            response.getWriter().append(res);
        } else {
            String res = ResponseFormat.resFormat("500", "管理员删除失败", null);
            response.getWriter().append(res);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
