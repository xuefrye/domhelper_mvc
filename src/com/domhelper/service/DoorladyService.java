package com.domhelper.service;

import com.domhelper.bean.impl.Doorlady;
import com.domhelper.bean.impl.PageBean;

/**
 * @Author: xuefrye
 * @Date: 2019/4/21 17:02
 * @Version: 1.0
 * @File: DoorladyService
 * @Description:
 */
public interface DoorladyService {
    int cancelProveById(int id);

    PageBean<Doorlady> findByPage(int CurrentPage,int rowCount);
}
