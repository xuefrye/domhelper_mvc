package com.domhelper.service.impl;

import com.domhelper.bean.Admin;
import com.domhelper.dao.AdminDao;
import com.domhelper.dao.impl.AdminDaoImpl;
import com.domhelper.service.AdminService;

import java.util.List;

/**
 * @Author: xuefrye
 * @Date: 2019/4/20 4:00
 * @Version: 1.0
 * @File: AdminServiceImpl
 * @Description:
 */
public class AdminServiceImpl implements AdminService {

    //策略模式
    private AdminDao dao = new AdminDaoImpl();

    @Override
    public int add(Admin admin) {
        return dao.add(admin);
    }

    @Override
    public Admin findById(int id) {
        return dao.findById(id);
    }

    @Override
    public int deleteById(int id) {
        return dao.deleteById(id);
    }

    @Override
    public List<Admin> findAll() {
        return dao.findAll();
    }

    @Override
    public Admin login(String adminName, String password) {
        return dao.findByAdminNameAndPassword(adminName, password);
    }
}
