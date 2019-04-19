package com.domhelper.dao.Impl;

import com.domhelper.bean.Admin;
import com.domhelper.dao.AdminDao;
import com.domhelper.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @Author: xuefrye
 * @Date: 2019/4/19 23:00
 * @Version: 1.0
 * @File: AdminDaoImpl
 * @Description:
 */
public class AdminDaoImpl implements AdminDao {

    //连接模板对象
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());


    @Override
    public int addAdmin(Admin admin) {
        String sql = "insert into admin_table (admin_id,admin_password,real_name) values (?, ?, ?)";
        int result = template.update(sql, admin.getAdminName(),
                admin.getAdminPassword(),
                admin.getRealName());
        return result;
    }

    @Override
    public Admin findAdminById(int id) {
        String sql = "select * from admin_table where admin_id = ?";

        //TODO 添加异常处理
        Admin admin = template.queryForObject(sql, new BeanPropertyRowMapper<>(Admin.class), id);
        return admin;
    }

    @Override
    public List<Admin> findAllAdmin() {
        String sql = "select * from admin_table";
        List<Admin> admins = template.query(sql, new BeanPropertyRowMapper<>(Admin.class));
        return admins;
    }
}


/*class AdminRowMapper implements RowMapper<Admin> {

    @Override
    public Admin mapRow(ResultSet resultSet, int i) throws SQLException {
        Admin admin = new Admin();
        admin.setAdminName(resultSet.getString("admin"));
        admin.setAdminId(resultSet.getInt("admid"));
        admin.setAdminPassword(resultSet.getString("admin_password"));
        admin.setRealName();
        admin.setSuperAdmin();

    }
}*/
