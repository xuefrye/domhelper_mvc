package com.domhelper.test;

import com.domhelper.bean.impl.Admin;
import com.domhelper.bean.impl.Doorlady;
import org.junit.Test;

/**
 * @Author: xuefrye
 * @Date: 2019/4/19 22:36
 * @Version: 1.0
 * @File: BeanTest
 * @Description: bean包测试类
 */
public class BeanTest {

    /**
     * 测试Admin json转换
     */
    @Test
    public void testAdmin(){
        Admin admin = new Admin();

        admin.setAdminId(1);
        admin.setAdminPassword("xixi");
        admin.setAdminName(null); //null不转换到json

        System.out.println(admin.toJSONString());
        System.out.println(admin.toJSONObject());
    }


    /**
     * 测试doorlady json转换
     */
    @Test
    public void testDoorlady(){
        Doorlady doorlady = new Doorlady();
        doorlady.setDoorladyId(123);
        doorlady.setDoorladyName("qwer");

        System.out.println(doorlady.toJSONString());
        System.out.println(doorlady.toJSONObject());
    }

}
