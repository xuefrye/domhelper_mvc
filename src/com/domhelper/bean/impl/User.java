package com.domhelper.bean.impl;

import com.alibaba.fastjson.JSONObject;
import com.domhelper.bean.JsonBean;

import java.util.Date;

/**
 * @Author: xuefrye
 * @Date: 2019/4/18 4:38
 * @Version: 1.0
 * @File: User
 * @Description: user_table实体类
 */
public class User implements JsonBean {
    String userid;
    String openid;
    String username;
    String usernick;
    String sutNum;
    String gender;
    String tel;
    String university;
    String school;
    String major;
    String grade;
    Date entrancetime;
    Date graduatetime;
    String headurl;
    String studentcard;
    int isprove;
    String dorm_building;
    String dorm_num;

    @Override
    public String toJSONString() {
        return null;
    }

    @Override
    public JSONObject toJSONObject() {
        return null;
    }

    //TODO
}
