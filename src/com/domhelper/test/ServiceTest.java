package com.domhelper.test;

import com.domhelper.bean.impl.Admin;
import com.domhelper.service.AdminService;
import com.domhelper.service.impl.AdminServiceImpl;
import org.junit.Test;

import java.util.List;

/**
 * @Author: xuefrye
 * @Date: 2019/4/20 3:52
 * @Version: 1.0
 * @File: ServiceTest
 * @Description:
 */
public class ServiceTest {

    //Test OK
    @Test
    public void test_adminService() {
        AdminService service = new AdminServiceImpl();

        List<Admin> admins = service.findAll();

        for (Admin admin : admins) {
            System.out.println(admin.toJSONString());
        }
    }
}
