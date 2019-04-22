package com.domhelper.web.servlet.userLoginServlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.domhelper.utils.ResponseFormat;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    //	小程序配置参数
    protected final String appId = "wx3adf87403b1087d1";
    protected final String serect = "123b3f3966e3a4039e6e7888f9a08f20";
    private String sessionKey;
    private String openId;
    //  登录SESSION
    private String makeSession;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		设置响应头
        response.setHeader("Content-Type", "application/json;charset=utf8");
//		获取登录参数
        String code = request.getParameter("code");
        String signature = request.getParameter("signature");
//		String iv=request.getParameter("iv");
//		String encryptedData=request.getParameter("encryptedData");
//		String rawData=request.getParameter("rawData");
        String rawData = new String(request.getParameter("rawData").getBytes("iso-8859-1"), "utf-8");
        String avatarUrl = request.getParameter("avatarUrl");
        String nickName = new String(request.getParameter("nickName").getBytes("iso-8859-1"), "utf-8");
        if (code == null || signature == null || rawData == null || avatarUrl == null || nickName == null) {
            response.getWriter().append("登录参数错误！");
            return;
        }
        this.getSessionKey(code);
//			数字签名验证
//		String signature2=DigestUtils.sha1Hex(rawData+this.sessionKey);
        String signature2 = String.valueOf(DigestUtils.sha1Hex(rawData + this.sessionKey));
        if (this.sessionKey == null) {
            response.getWriter().append("sessionkey获取失败");
            return;
        }
        if (signature.equals(signature2)) {
            this.makeSession();
        } else {
            response.getWriter().append("数字签名校验失败！");
            return;
        }
//		如果为真，则表示已注册过
        Boolean query = this.queryUser();
        if (query) {
            JSONArray data = new JSONArray();
            JSONObject userInfo = this.getUser();
            data.add(this.makeSession);
            data.add(userInfo);
            String res = ResponseFormat.resFormat("200", "用户注册已注册过！", data);
            response.getWriter().append(res);
            return;
        }
//		插入用户信息
        Boolean register = this.register(nickName, avatarUrl);
        if (!register) {
            response.getWriter().append("用户注册失败！");
            return;
        } else {
            JSONArray data = new JSONArray();
            JSONObject userInfo = this.getUser();
            data.add(this.makeSession);
            data.add(userInfo);
            String res = ResponseFormat.resFormat("200", "用户注册成功！", data);
            response.getWriter().append(res);
        }
//		返回登录态

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    //	请求微信接口
    private void getSessionKey(String code) {
//		请求url
        try {
            URL url = new URL("https://api.weixin.qq.com/sns/jscode2session?appid=" + this.appId + "&secret=" + this.serect + "&js_code=" + code + "&grant_type=authorization_code");
            try {
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.connect();
                // 获取输入流
                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
                String line;
                StringBuilder sb = new StringBuilder();
                while ((line = br.readLine()) != null) {// 循环读取流
                    sb.append(line);
                }
                br.close();// 关闭流
                con.disconnect();// 断开连接
                JSONObject rs = JSON.parseObject(sb.toString());
                this.sessionKey = rs.getString("session_key");
                this.openId = rs.getString("openid");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("未知错误!");
            }
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("未知错误!");
        }
    }

    //	查询用户是否已注册
    private Boolean queryUser() {
        Connection db = Database.connect();
        try {
            Statement stmt = db.createStatement();
            String sql = "SELECT * FROM user_table WHERE openid='" + this.openId + "'";
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
//				关闭数据库相关操作
                Database.release(rs, stmt, db);
                return true;
            } else {
//				关闭数据库相关操作
                Database.release(rs, stmt, db);
                return false;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            Database.release(db);
            return false;
        }

    }

    //	用户注册。写入数据库
    private Boolean register(String nickName, String headurl) {
        Connection db = Database.connect();
        long time = new Date().getTime();
        int rand = (int) (Math.random() * 9999);
        String userid = "U" + time + rand;
        try {
            Statement stmt = db.createStatement();
            String sql = "INSERT INTO user_table (userid,openid,usernick,headurl) VALUES ('" + userid + "','" + this.openId + "','" + nickName + "','" + headurl + "')";
            int rs = stmt.executeUpdate(sql);
            Database.release(stmt, db);
            if (rs > 0) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            Database.release(db);
            return false;
        }

    }

    //	生成登录态
    private void makeSession() {
        String makeSession = DigestUtils.sha1Hex(this.openId + this.sessionKey);
        this.makeSession = makeSession;
    }

    private JSONObject getUser() {
        Connection db = Database.connect();
        JSONObject data = new JSONObject();
        try {
            Statement stmt = db.createStatement();
            String sql = "SELECT * FROM user_table WHERE openid='" + this.openId + "'";
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                String userid = rs.getString("userid");
                String username = rs.getString("username");  //用户名
                String usernick = rs.getString("usernick");  //昵称
                String gender = rs.getString("gender");      //性别
                String headurl = rs.getString("headurl");
//				String tel=rs.getString("tel");  //电话
                String university = rs.getString("university");  //大学
                String school = rs.getString("school");  //学院
                String entrancetime = rs.getString("entrancetime");  //入校时间
//				String graduatetime=rs.getString("graduatetime");  //毕业时间
//				String studentcard=rs.getString("studentcard");  //学生号
                String dorm_building = rs.getString("dorm_building");  //宿舍楼
                String dorm_num = rs.getString("dorm_num");  //宿舍房间号
                String isprove = rs.getString("isprove");  //是否认证

                data.put("userId", userid);
                data.put("userName", username);
                data.put("userNick", usernick);
                data.put("gender", gender);
                data.put("headUrl", headurl);
                data.put("university", university);
                data.put("school", school);
                data.put("entranceTime", entrancetime);
                data.put("dormBuilding", dorm_building);
                data.put("dormNum", dorm_num);
                data.put("isProve", isprove);
//				关闭数据库相关操作
                Database.release(rs, stmt, db);
                return data;
            } else {
//				关闭数据库相关操作
                Database.release(rs, stmt, db);
                return data;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            Database.release(db);
            return data;
        }
    }
}
