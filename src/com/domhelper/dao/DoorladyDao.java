package com.domhelper.dao;

import com.domhelper.bean.impl.Admin;
import com.domhelper.bean.impl.Doorlady;

import java.util.List;

/**
 * @Author: xuefrye
 * @Date: 2019/4/21 16:56
 * @Version: 1.0
 * @File: DoorladyDao
 * @Description:
 */
public interface DoorladyDao {
    /**
     * 添加宿管到doorlady_table
     *
     * @param doorlady 需要添加的宿管对象
     * @return 返回0说明添加失败
     */
    int add(Doorlady doorlady);

    /**
     * 通过id查找宿管
     *
     * @param id 宿管id
     * @return 若查找不到返回null
     */
    Admin findById(int id);

    /**
     * 查询所有宿管
     *
     * @return 所有的宿管信息
     */
    List<Doorlady> findAll();


    /**
     * 通过id删除宿管
     *
     * @param id 宿管id
     * @return 返回0说明删除失败
     */
    int deleteById(int id);


    /**
     * 取消宿管验证
     * @param id 宿管id
     * @return 返回0说明操作失败
     */
    int cancelProveById(int id);

    /**
     * 认证宿管
     * @param id
     * @return
     */
    int proveById(int id);

    /**
     * 修改已有信息
     * @param doorlady
     * @return
     */
    int update(Doorlady doorlady);

}


/*    *//**
 * 宿管登录查询
 *
 * @param name 宿管账号
 * @param password  密码
 * @return 若查找不到返回null
 *//*
    Admin findDoorladyByNameAndPassword(String name, String password);*/