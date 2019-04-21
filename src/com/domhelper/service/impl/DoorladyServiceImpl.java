package com.domhelper.service.impl;

import com.domhelper.dao.DoorladyDao;
import com.domhelper.dao.impl.DoorladyDaoImpl;
import com.domhelper.service.DoorladyService;

/**
 * @Author: xuefrye
 * @Date: 2019/4/21 17:16
 * @Version: 1.0
 * @File: DoorladyServiceImpl
 * @Description:
 */
public class DoorladyServiceImpl implements DoorladyService {
    private DoorladyDao dao = new DoorladyDaoImpl();

    @Override
    public int cancelProveById(int id) {
        return dao.cancelProveById(id);
    }
}
