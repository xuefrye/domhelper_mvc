package com.domhelper.dao.impl;

import com.domhelper.bean.impl.Admin;
import com.domhelper.bean.impl.Doorlady;
import com.domhelper.dao.DoorladyDao;
import com.domhelper.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @Author: xuefrye
 * @Date: 2019/4/21 17:00
 * @Version: 1.0
 * @File: DoorladyDaoImpl
 * @Description:
 */
public class DoorladyDaoImpl implements DoorladyDao {
    //连接模板对象
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public int add(Doorlady doorlady) {
        //TODO
        return 0;
    }

    @Override
    public Admin findById(int id) {
        //TODO
        return null;
    }

    @Override
    public List<Doorlady> findAll() {
        String sql = "select * from doorlady_table";
        List<Doorlady> doorladyList = template.query(sql, new BeanPropertyRowMapper<>(Doorlady.class));
        return doorladyList;
    }

    @Override
    public int deleteById(int id) {
        //TODO
        return 0;
    }

    @Override
    public int cancelProveById(int id) {
        String sql = " update doorlady_table set is_proved = 0 where doorlady_id = ? ";
        return template.update(sql, id);
    }

    @Override
    public int proveById(int id) {
        String sql = " update doorlady_table set is_proved = 1 where doorlady_id = ? ";
        return template.update(sql, id);
    }

    @Override
    public int update(Doorlady doorlady) {
        String sql = " update doorlady_table set doorlady_name=?, gender=?, " +
                "tel=?, school=?, head_url=?, university=?, dorm_building=? where doorlady_id = ? ";
        int result = template.update(sql,
                doorlady.getDoorladyName(),
                doorlady.getGender(),
                doorlady.getTel(),
                doorlady.getSchool(),
                doorlady.getHeadUrl(),
                doorlady.getUniversity(),
                doorlady.getDormBuilding(),
                doorlady.getDoorladyId());
        return result;
    }


}
