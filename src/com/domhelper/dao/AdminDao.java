package com.domhelper.dao;

import com.domhelper.bean.Admin;

import java.util.List;

/**
 * @Author: xuefrye
 * @Date: 2019/4/19 22:29
 * @Version: 1.0
 * @File: AdminDao
 * @Description: admin_table表数据库访问接口
 */
public interface AdminDao {
    /**
     * 添加管理员到admin_table
     *
     * @param admin 需要添加的管理员对象
     * @return 返回0说明添加失败
     */
    int add(Admin admin);

    /**
     * 通过id查找管理员
     *
     * @param id 管理员id
     * @return 若查找不到返回null
     */
    Admin findById(int id);

    /**
     * 查询所有管理员
     *
     * @return 所有的管理员信息
     */
    List<Admin> findAll();


    /**
     * 通过id删除管理员
     *
     * @param id 管理员id
     * @return 返回0说明删除失败
     */
    int deleteById(int id);

    /**
     * 管理员登录查询
     *
     * @param adminName 管理员账号
     * @param password  密码
     * @return 若查找不到返回null
     */
    Admin findByAdminNameAndPassword(String adminName, String password);
}
