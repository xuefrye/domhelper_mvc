package com.domhelper.user;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.binary.Base64;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Servlet implementation class BeforeProve
 */
@WebServlet("/BeforeProveServlet")
public class BeforeProveServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		得到获取验证码cookie
        String cookie = this.initLogin();
//		取sto-id，用于登录
        String stoCookie = cookie.split(";")[1];
        URL url = new URL("http://210.42.121.241/servlet/GenImg");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Connection", "keep-alive");
        con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) " +
                "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.121 Safari/537.36");
        con.setRequestProperty("Cookie", cookie);
        con.connect();
        String cookie2 = this.getCookie(con);

        InputStream inStream = con.getInputStream();
        BufferedImage src = ImageIO.read(inStream);

        ByteArrayOutputStream bs = new ByteArrayOutputStream();
        ImageIO.write(src, "jpg", bs);
        byte[] bytes = bs.toByteArray();//转换成字节
        Base64 base64 = new Base64();
        String png_base64 = base64.encodeToString(bytes);

//	    OutputStream out = response.getOutputStream();
//	    out.write(bs.toByteArray());
        JSONObject data = new JSONObject();
        data.put("cookie", cookie2 + stoCookie);
        data.put("imgSrc", "data:image/jpg;base64," + png_base64);
        response.getWriter().append(data.toJSONString());
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }


    /**
     * @return 返回cookie
     */
    private String initLogin() {
        String cookie = "";
        try {
            URL url = new URL("http://210.42.121.241/");
            HttpURLConnection con;
            try {
                con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.setRequestProperty("Connection", "keep-alive");
                con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.121 Safari/537.36");
                con.connect();
                cookie = this.getCookie(con);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return cookie;
    }

    //	获取cookie
    private String getCookie(HttpURLConnection con) {
        String cookieVal = null;
        String key = null;
        String sessionId = "";
        for (int i = 1; (key = con.getHeaderFieldKey(i)) != null; i++) {
            if (key.equalsIgnoreCase("set-cookie")) {
                cookieVal = con.getHeaderField(i);
                cookieVal = cookieVal.substring(0, cookieVal.indexOf(";"));
                sessionId = sessionId + cookieVal + ";";
            }
        }
        return sessionId;
    }
}
