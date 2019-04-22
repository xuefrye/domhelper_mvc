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
    int doorladyId;

    @JSONField(name = "doorlady_name")
    String doorladyName;

    @JSONField(name = "openid")
    String openid;

    @JSONField(name = "gender")
    String gender;

    @JSONField(name = "tel")
    String tel;

    @JSONField(name = "school")
    String school;

    @JSONField(name = "dorm_building")
    String dormBuilding;

    @JSONField(name = "headurl")
    String headurl;

    @JSONField(name = "is_proved")
    String isProved;

    @JSONField(name = "university")
    String university;

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

    public String getHeadurl() {
        return headurl;
    }

    public void setHeadurl(String headurl) {
        this.headurl = headurl;
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

    @Override
    public String toString() {
        return "Doorlady{" +
                "doorladyId=" + doorladyId +
                ", doorladyName='" + doorladyName + '\'' +
                ", openid='" + openid + '\'' +
                ", gender='" + gender + '\'' +
                ", tel='" + tel + '\'' +
                ", school='" + school + '\'' +
                ", dormBuilding='" + dormBuilding + '\'' +
                ", headurl='" + headurl + '\'' +
                ", isProved='" + isProved + '\'' +
                ", university='" + university + '\'' +
                '}';
    }

    public String toJSONString() {
        return JSON.toJSONString(this);
    }

    public JSONObject toJSONObject() {
        return JSON.parseObject(this.toJSONString());
    }
}
