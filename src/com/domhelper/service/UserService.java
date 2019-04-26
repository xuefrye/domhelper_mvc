package com.domhelper.service;

import com.domhelper.bean.impl.User;

/**
 * @Author: xuefrye
 * @Date: 2019/4/22 22:02
 * @Version: 1.0
 * @File: UserService
 * @Description:
 */
public interface UserService {
    User findByOpenid(String openId);

    int add(User user);

    int update(User user);

    //TODO
}
