package com.domhelper.service;

import com.domhelper.bean.impl.Admin;

import java.util.List;

/**
 * @Author: xuefrye
 * @Date: 2019/4/20 3:49
 * @Version: 1.0
 * @File: AdminService
 * @Description:
 */
public interface AdminService {
    int add(Admin admin);

    Admin findById(int id);

    int deleteById(int id);

    List<Admin> findAll();

    Admin login(String adminName, String password);
}
