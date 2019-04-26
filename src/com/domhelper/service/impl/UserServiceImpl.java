package com.domhelper.service.impl;

import com.domhelper.bean.impl.User;
import com.domhelper.dao.UserDao;
import com.domhelper.dao.impl.UserDaoImpl;
import com.domhelper.service.UserService;

/**
 * @Author: xuefrye
 * @Date: 2019/4/22 22:02
 * @Version: 1.0
 * @File: UserServiceImpl
 * @Description:
 */
public class UserServiceImpl implements UserService {

    UserDao dao = new UserDaoImpl();

    @Override
    public User findByOpenid(String openId) {
        return dao.findByOpenId(openId);
    }

    @Override
    public int add(User user) {
        return dao.add(user);
    }

    @Override
    public int update(User user) {
        return dao.update(user);
    }
}
