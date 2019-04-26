package com.domhelper.test.otherTest;

import com.domhelper.dao.AdminDao;
import org.junit.Test;

/**
 * @Author: xuefrye
 * @Date: 2019/4/25 20:39
 * @Version: 1.0
 * @File: ClassTest
 * @Description:
 */
public class ClassTest {
    @Test
    public void test01(){
        Class<? super AdminDao> superclass = AdminDao.class.getSuperclass();
        System.out.println(superclass.getCanonicalName());
    }
}
