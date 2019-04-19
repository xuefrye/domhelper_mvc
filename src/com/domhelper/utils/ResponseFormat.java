package com.domhelper.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @Author: xuefrye
 * @Date: 2019/4/19 22:07
 * @Version: 1.0
 * @File: ResponseFormat
 * @Description:
 */
public class ResponseFormat {
    public static String resFormat(String code, String msg, JSONArray data) {

        JSONObject list=new JSONObject();
        list.put("code", code);
        list.put("msg",msg);
        list.put("data",data);
        return list.toString();
    }
    public static String resFormat(String code,String msg,JSONArray data,int pageCount) {

        JSONObject list=new JSONObject();
        list.put("code", code);
        list.put("msg",msg);
        list.put("data",data);
        list.put("pageCount",pageCount);
        return list.toString();
    }
}
