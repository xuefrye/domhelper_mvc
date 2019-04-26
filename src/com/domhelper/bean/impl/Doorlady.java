package com.domhelper.bean.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.domhelper.bean.JsonBean;

/**
 * @Author: xuefrye
 * @Date: 2019/4/21 16:24
 * @Version: 1.0
 * @File: Doorlady
 * @Description: doorlady_table实体类
 */
public class Doorlady implements JsonBean {
    @JSONField(name = "doorlady_id")
    private int doorladyId;

    @JSONField(name = "doorlady_name")
    private String doorladyName;

    @JSONField(name = "openid")
    private String openid;

    @JSONField(name = "gender")
    private String gender;

    @JSONField(name = "tel")
    private String tel;

    @JSONField(name = "school")
    private String school;

    @JSONField(name = "dorm_building")
    private String dormBuilding;

    @JSONField(name = "head_url")
    private String headUrl;

    @JSONField(name = "is_proved")
    private String isProved;

    @JSONField(name = "university")
    private String university;

    public int getDoorladyId() {
        return doorladyId;
    }

    public void setDoorladyId(int doorladyId) {
        this.doorladyId = doorladyId;
    }

    public String getDoorladyName() {
        return doorladyName;
    }

    public void setDoorladyName(String doorladyName) {
        this.doorladyName = doorladyName;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getDormBuilding() {
        return dormBuilding;
    }

    public void setDormBuilding(String dormBuilding) {
        this.dormBuilding = dormBuilding;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public String getIsProved() {
        return isProved;
    }

    public void setIsProved(String isProved) {
        this.isProved = isProved;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String toJSONString() {
        return JSON.toJSONString(this);
    }

    public JSONObject toJSONObject() {
        return JSON.parseObject(this.toJSONString());
    }
}
