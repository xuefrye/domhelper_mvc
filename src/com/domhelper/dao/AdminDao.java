package com.domhelper.dao;

import com.domhelper.bean.Admin;

import java.util.List;

/**
 * @Author: xuefrye
 * @Date: 2019/4/19 22:29
 * @Version: 1.0
 * @File: AdminDao
 * @Description:
 */
public interface AdminDao {
    int addAdmin(Admin admin);

    Admin findAdminById(int id);

    List<Admin> findAllAdmin();
}
