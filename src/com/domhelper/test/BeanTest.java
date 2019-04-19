package com.domhelper.test;

import com.alibaba.fastjson.JSON;
import com.domhelper.bean.Admin;
import org.junit.Test;

/**
 * @Author: xuefrye
 * @Date: 2019/4/19 22:36
 * @Version: 1.0
 * @File: BeanTest
 * @Description: bean包测试
 */
public class BeanTest {

    @Test
    public void testToJsonString(){
        Admin admin = new Admin();

        admin.setAdminId(1);
        admin.setAdminName(null); //null不转换

        String json = admin.toJSONString();
        System.out.println(json);
    }


}
