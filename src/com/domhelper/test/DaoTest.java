package com.domhelper.test;

import com.domhelper.bean.Admin;
import com.domhelper.dao.AdminDao;
import com.domhelper.dao.Impl.AdminDaoImpl;
import com.domhelper.utils.JDBCUtils;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @Author: xuefrye
 * @Date: 2019/4/19 22:58
 * @Version: 1.0
 * @File: DaoTest
 * @Description: dao包测试类
 */
public class DaoTest {


    /**
     * admin_table 查询/json测试
     */
    @Test
    public void test_findAdminById() {
        AdminDao dao = new AdminDaoImpl();

        List<Admin> admins = dao.findAllAdmin();
        System.out.println(admins);

        for (Admin admin : admins) {
            System.out.println(admin.toJSONString());
        }
    }
}
