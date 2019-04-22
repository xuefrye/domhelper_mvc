package com.domhelper.test.otherTest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.domhelper.bean.impl.Admin;
import org.junit.Test;

/**
 * @Author: xuefrye
 * @Date: 2019/4/20 11:34
 * @Version: 1.0
 * @File: fastjsonTest
 * @Description:
 */
public class fastjsonTest {

    @Test
    public void testjson(){
        Admin admin = new Admin();
        admin.setAdminId(1);
        admin.setAdminName("123");
        JSONObject jsonObject = JSON.parseObject(admin.toJSONString());
        //JSONArray jsonArray1 = JSON.parseArray(admin.toJSONString());

        JSONArray jsonArray = new JSONArray();
        jsonArray.add(jsonObject);

        System.out.println(jsonObject);
        System.out.println(jsonArray);
        //System.out.println(jsonArray1);
    }
}
