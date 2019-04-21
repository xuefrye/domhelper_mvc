package com.domhelper.web.servlet.doorLadyServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: xuefrye
 * @Date: 2019/4/21 17:22
 * @Version: 1.0
 * @File: GetDoorladyListServlet
 * @Description:
 */
@WebServlet("/GetDoorladyListServlet")
public class GetDoorladyListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置响应头
        response.setHeader("Content-Type", "application/json;charset=utf-8;");
        response.setHeader("Allow", "GET");

/*TODO		检查登录态
        if (!AdminSafe.CheckSession(request, response)) {
            return;
        }*/

        //rowCount:总共的记录数
        int rowCount = 0;
        //pageNow:表示要显示第几页，由用户设置；初始化为1
        int pageNow = 1;
        //pageSize:每一页显示几条记录
        int pageSize = 20;
        //pageCount:总页数
//		int pageCount = rowCount%pageSize==0?rowCount/pageSize: rowCount/pageSize+1;
        //<a>链接中的href传递过来的参数
        String temp_pageNow = request.getParameter("pageNow");
        if (temp_pageNow != null) {
            pageNow = Integer.parseInt(temp_pageNow);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
