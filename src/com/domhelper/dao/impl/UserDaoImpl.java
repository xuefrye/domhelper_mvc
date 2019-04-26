package com.domhelper.dao.impl;

import com.domhelper.bean.impl.User;
import com.domhelper.dao.UserDao;
import com.domhelper.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @Author: xuefrye
 * @Date: 2019/4/18 4:54
 * @Version: 1.0
 * @File: UserDaoImpl
 * @Description: UserDao实现类
 */

public class UserDaoImpl implements UserDao {
    //连接模板对象
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public User findByOpenId(String openId) {
        User user = null;

        String sql = "select * from user_table where open_id = ?";
        user = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), openId);

        return user;
    }

    @Override
    public int add(User user) {
        String sql = "insert into user_table (user_id, open_id, user_nick, head_url) values (?, ?, ?, ?)";
        int result = template.update(sql,
                user.getUserId(),
                user.getOpenId(),
                user.getUserName(),
                user.getHeadUrl());
        return result;
    }

    @Override
    public int update(User user) {
        String sql = " update user_table set " +
                " user_name = ?, stu_num = ?, gender = ?, school = ?, major = ? ,grade = ?, is_prove = 1 " +
                " where user_id = ? ";

        int result = template.update(sql,
                user.getUserName(),
                user.getStuNum(),
                user.getGender(),
                user.getSchool(),
                user.getMajor(),
                user.getGrade(),
                user.getUserId());
        return result;
    }


    //TODO
}
