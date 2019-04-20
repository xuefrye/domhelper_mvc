package com.domhelper.test;

import com.alibaba.fastjson.JSONArray;
import com.domhelper.bean.Admin;
import com.domhelper.dao.AdminDao;
import com.domhelper.dao.impl.AdminDaoImpl;
import org.junit.Test;

import java.util.List;

/**
 * @Author: xuefrye
 * @Date: 2019/4/19 22:58
 * @Version: 1.0
 * @File: DaoTest
 * @Description: dao包测试类
 */
public class DaoTest {

    private AdminDao dao = new AdminDaoImpl();

    /**
     * admin_table 查询/json测试
     */
    @Test
    public void test_findAdminById() {

        List<Admin> admins = dao.findAllAdmin();
        System.out.println(admins);

        for (Admin admin : admins) {
            System.out.println(admin.toJSONString());
        }
    }

    @Test
    public void test_delete() {
        dao.deleteAdminById(9999);
    }

    @Test
    public void test_findAll() {
        JSONArray adminArray = new JSONArray();
        List<Admin> adminList = dao.findAllAdmin();
        for (Admin admin : adminList) {
            adminArray.add(admin.toJSONObject());
        }
        System.out.println(adminArray);
    }
}
