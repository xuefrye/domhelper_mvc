package com.domhelper.dao.impl;

import com.domhelper.dao.NoticeTableDao;
import com.domhelper.utils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @Author: xuefrye
 * @Date: 2019/4/18 4:57
 * @Version: 1.0
 * @File: NoticeTableDaoImpl
 * @Description: NoticeTableDao实现类
 */
public class NoticeTableDaoImpl implements NoticeTableDao {
    //连接模板对象
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    //TODO
}
