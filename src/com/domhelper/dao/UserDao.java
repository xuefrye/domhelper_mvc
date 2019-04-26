package com.domhelper.dao;

import com.domhelper.bean.impl.User;

/**
 * @Author: xuefrye
 * @Date: 2019/4/18 4:54
 * @Version: 1.0
 * @File: UserDao
 * @Description: user_table表数据库访问接口
 */
public interface UserDao {
    User findByOpenId(String openId);

    int add(User user);

    int update(User user);
}
