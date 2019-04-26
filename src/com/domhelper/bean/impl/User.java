package com.domhelper.bean.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.domhelper.bean.JsonBean;

import java.util.Date;

/**
 * @Author: xuefrye
 * @Date: 2019/4/26 4:38
 * @Version: 1.0
 * @File: User
 * @Description: user_table实体类
 */
public class User implements JsonBean {
    @JSONField(name = "user_id")
    private String userId;

    @JSONField(name = "open_id")
    private String openId;

    @JSONField(name = "user_name")
    private String userName;

    @JSONField(name = "user_nick")
    private String userNick;

    @JSONField(name = "stu_num")
    private String stuNum;

    @JSONField(name = "gender")
    private String gender;

    @JSONField(name = "tel")
    private String tel;

    @JSONField(name = "university")
    private String university;

    @JSONField(name = "school")
    private String school;

    @JSONField(name = "major")
    private String major;

    @JSONField(name = "grade")
    private String grade;

    @JSONField(name = "entrance_time")
    private Date entranceTime;

    @JSONField(name = "graduate_time")
    private Date graduateTime;

    @JSONField(name = "head_url")
    private String headUrl;

    @JSONField(name = "student_card")
    private String studentCard;

    @JSONField(name = "is_prove")
    private int isProve;

    @JSONField(name = "dorm_building")
    private String dormBuilding;

    @JSONField(name = "dorm_cnt")
    private String dormNum;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserNick() {
        return userNick;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
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

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Date getEntranceTime() {
        return entranceTime;
    }

    public void setEntranceTime(Date entranceTime) {
        this.entranceTime = entranceTime;
    }

    public Date getGraduateTime() {
        return graduateTime;
    }

    public void setGraduateTime(Date graduateTime) {
        this.graduateTime = graduateTime;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public String getStudentCard() {
        return studentCard;
    }

    public void setStudentCard(String studentCard) {
        this.studentCard = studentCard;
    }

    public int getIsProve() {
        return isProve;
    }

    public void setIsProve(int isProve) {
        this.isProve = isProve;
    }

    public String getDormBuilding() {
        return dormBuilding;
    }

    public void setDormBuilding(String dormBuilding) {
        this.dormBuilding = dormBuilding;
    }

    public String getDormNum() {
        return dormNum;
    }

    public void setDormNum(String dormNum) {
        this.dormNum = dormNum;
    }

    @Override
    public String toJSONString() {
        return JSON.toJSONString(this);
    }

    @Override
    public JSONObject toJSONObject() {
        return JSON.parseObject(this.toJSONString());
    }
}
