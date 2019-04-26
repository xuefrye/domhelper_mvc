package com.domhelper.bean.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.domhelper.bean.JsonBean;

import java.time.DateTimeException;
import java.util.Date;

/**
 * @Author: xuefrye
 * @Date: 2019/4/26 4:57
 * @Version: 1.0
 * @File: Notice
 * @Description: notice_table实体类
 */
public class Notice implements JsonBean {
    @JSONField(name = "notice_id")
    private int noticeId;

    @JSONField(name = "notice_title")
    private String noticeTitle;

    @JSONField(name = "notice_content")
    private String noticeContent;

    @JSONField(name = "doorlady_id")
    private String doorladyId;

    @JSONField(name = "send_time")
    private Date sendTime;

    @JSONField(name = "notice_type")
    private String noticeType;

    @JSONField(name = "id_deleted")
    private int isDeleted;

    @JSONField(name = "is_top")
    private int isTop;

    public int getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(int noticeId) {
        this.noticeId = noticeId;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    public String getDoorladyId() {
        return doorladyId;
    }

    public void setDoorladyId(String doorladyId) {
        this.doorladyId = doorladyId;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public String getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(String noticeType) {
        this.noticeType = noticeType;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public int getIsTop() {
        return isTop;
    }

    public void setIsTop(int isTop) {
        this.isTop = isTop;
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
