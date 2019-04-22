package com.domhelper.web.servlet.userLoginServlet;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Servlet implementation class userProve
 */
@WebServlet("/userProve")
public class UserProveServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private String userId = "";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.getWriter().append("请求方式错误！");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Content-Type", "application/json;charset=utf8");
        String studentNumber = request.getParameter("studentNumber");
        String studentPwd = request.getParameter("studentPwd");
        String cookie = request.getParameter("cookie");
        String code = request.getParameter("code");
        this.userId = request.getParameter("userId");
        if (studentNumber == "" || studentPwd == "" || cookie == "" || code == "" || this.userId == "") {
            JSONObject res = new JSONObject();
            res.put("code", "501");
            res.put("msg", "请求参数错误");
            response.getWriter().append(res.toJSONString());
            return;
        }
        int content = (int) (Math.random() * 900 + 100);

        URL url = new URL("http://210.42.121.241/servlet/Login");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Cookie", cookie);
        con.setRequestProperty("Cache-Control", "max-age=0");
        con.setRequestProperty("Connection", "keep-alive");
        con.setRequestProperty("Charset", "UTF-8");
        con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.121 Safari/537.36");
        con.setDoInput(true);
        con.setDoOutput(true);
        con.setInstanceFollowRedirects(false);
        // 设置不用缓存
        con.setUseCaches(false);
        con.connect();
//		请求body
        String params = "id=" + URLEncoder.encode(studentNumber, "UTF-8") + "&content=" + URLEncoder.encode(content + ",", "UTF-8") + "&pwd=" + URLEncoder.encode(studentPwd, "UTF-8") + "&xdvfb=" + URLEncoder.encode(code, "UTF-8");
//		String params = "id="+studentNumber+"&content="+content+","+"&pwd="+studentPwd+"&xdvfb="+code;
        System.out.println(params);
        OutputStream out = con.getOutputStream();
        out.write(params.getBytes());
        out.flush();
        String location = con.getHeaderField("Location");
        System.out.println(location + "__" + con.getResponseCode());
        out.close(); // flush and close
//        BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream(), "GBK"));
//        String line;
//        System.out.println("Contents of post request:");
//        while ((line = reader.readLine()) != null)  {
//            System.out.println(line);
//        }
        con.disconnect();
        if (location == null) {
            location = "null";
        }
        if (location.compareTo("http://210.42.121.241/servlet/../") == 0) {
            JSONObject res = new JSONObject();
            res.put("code", "500");
            res.put("msg", "学号或密码错误");
            response.getWriter().append(res.toJSONString());
            return;
        } else if (location.compareTo("http://210.42.121.241/servlet/../stu/stu_index.jsp") == 0) {


        } else {
            JSONObject res = new JSONObject();
            res.put("code", "502");
            res.put("msg", "验证码错误");
            response.getWriter().append(res.toJSONString());
            return;
        }
        this.getInfo(cookie, response);
    }

    private void getInfo(String cookie, HttpServletResponse response) {
        URL url;
        try {
            url = new URL("http://210.42.121.241/stu/student_information.jsp");
            HttpURLConnection con;
            try {
                con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.121 Safari/537.36");
                con.setRequestProperty("Cookie", cookie);
                con.setRequestProperty("Connection", "keep-alive");
                con.connect();
                BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream(), "GBK"));
                String line;
                String data = "";
                while ((line = reader.readLine()) != null) {
//			            System.out.println(line);
                    data = data + line;
                }

                String stuNum = "";
                String relName = "";
                String gender = "";
                String school = "";
                String major = "";
                String grade = "";

//			    正则表达式获取有用数据
//			    学号
                Pattern stuNumPat = Pattern.compile("(<th width=\"10%\">学号</th><td width=\"23%\">)(.*?)(</td><th width=\"10%\">)");
                Matcher stuNumM = stuNumPat.matcher(data);
                if (stuNumM.find()) {
                    stuNum = stuNumM.group(2);
                }
//			    姓名
                Pattern relNamePat = Pattern.compile("(<th width=\"10%\">姓名</th><td width=\"23%\">)(.*?)(</td><th width=\"10%\">)");
                Matcher relNameM = relNamePat.matcher(data);
                if (relNameM.find()) {
                    relName = relNameM.group(2);
                }
//		        性别
                Pattern genderPat = Pattern.compile("(<th width=\"10%\">性别</th><td width=\"24%\">)(.*?)(</td>)");
                Matcher genderM = genderPat.matcher(data);
                if (genderM.find()) {
                    gender = genderM.group(2);
                }
//		    	学院
                Pattern schoolPat = Pattern.compile("(<th >院系名称</th><td>)(.*?)(</td><th>专业名称)");
                Matcher schoolM = schoolPat.matcher(data);
                if (schoolM.find()) {
                    school = schoolM.group(2);
                }
//		    	专业
                Pattern majorPat = Pattern.compile("(<th>专业名称</th><td>)(.*?)(</td><th>年级</th)");
                Matcher majorM = majorPat.matcher(data);
                if (majorM.find()) {
                    major = majorM.group(2);
                }
//		    	年级
                Pattern gradePat = Pattern.compile("(<th>年级</th><td>)(.*?)(</td>)");
                Matcher gradeM = gradePat.matcher(data);
                if (gradeM.find()) {
                    grade = gradeM.group(2);
                }
                con.disconnect();
//				保存在数据库
                Boolean isInsert = this.insertInfo(stuNum, relName, gender, school, major, grade);
                if (isInsert.booleanValue() == true) {
                    JSONObject res = new JSONObject();
                    res.put("code", "200");
                    res.put("msg", "认证成功");
                    response.getWriter().append(res.toJSONString());
                } else {
                    JSONObject res = new JSONObject();
                    res.put("code", "400");
                    res.put("msg", "未知异常");
                    response.getWriter().append(res.toJSONString());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    //	保存在数据库
    private Boolean insertInfo(String stuNum, String relName, String gender, String school, String major, String grade) {
       /*TODO 改用service方式查询数据库
        Connection db = Database.connect();
        try {
            Statement stmt = db.createStatement();
            String sql = String.format("UPDATE user_table SET username='%s',stuNum='%s',gender='%s',school='%s',major='%s',grade='%s',isprove='1' WHERE userid='%s'", relName, stuNum, gender, school, major, grade, this.userId);
            int rs = stmt.executeUpdate(sql);
            if (rs > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
*/
        return false;
    }

}
