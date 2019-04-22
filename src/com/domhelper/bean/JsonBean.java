package com.domhelper.bean;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author: xuefrye
 * @Date: 2019/4/22 14:14
 * @Version: 1.0
 * @File: JsonBean
 * @Description: 强制所有bean对象都要实现能转换为json的接口
 */
public interface JsonBean {
    /**
     * 转变为字符串表示的Json
     */
    String toJSONString();

    /**
     * 转变为Json对象
     */
    JSONObject toJSONObject();
}
