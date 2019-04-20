package com.domhelper.bean;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * @Author: xuefrye
 * @Date: 2019/4/19 22:29
 * @Version: 1.0
 * @File: Admin
 * @Description: admin_table实体类
 */
public class Admin {
    @JSONField(name = "admin_id")
    private Integer adminId;

    @JSONField(name = "admin_name")
    private String adminName;

    @JSONField(name = "admin_password")
    private String adminPassword;

    @JSONField(name = "real_name")
    private String realName;

    @JSONField(name = "is_super_admin")
    private Integer isSuperAdmin;

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getIsSuperAdmin() {
        return isSuperAdmin;
    }

    public void setIsSuperAdmin(Integer isSuperAdmin) {
        this.isSuperAdmin = isSuperAdmin;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", adminName='" + adminName + '\'' +
                ", adminPassword='" + adminPassword + '\'' +
                ", realName='" + realName + '\'' +
                ", isSuperAdmin=" + isSuperAdmin +
                '}';
    }

    public String toJSONString() {
        return JSON.toJSONString(this);
    }

    public JSONObject toJSONObject() {
        return JSON.parseObject(this.toJSONString());
    }
}
