package com.domhelper.bean;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * @Author: xue
 * @Date: 2019/4/21 17:23
 * @Version: 1.0
 * @File: PageBean
 * @Description: 封装每一页显示的内容和类型, 显示范围(页数, 行数)的JavaBean类, List<T> list 封装bean包下的实体类
 */
public class PageBean<T> {
    @JSONField(name = "total_count")
    private int totalCount; //总记录数 从数据库获取

    @JSONField(name = "total_page")
    private int totalPage; //总页码 从数据库获取

    @JSONField(name = "list")
    private List<T> list; //每页的数据对象

    @JSONField(name = "current_page")
    private int currentPage; //当前页码 从浏览器获取

    @JSONField(name = "row_count")
    private int rowCount; //每页显示数 从浏览器获取

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }


    @Override
    public String toString() {
        return "PageBean{" +
                "totalCount=" + totalCount +
                ", totalPage=" + totalPage +
                ", list=" + list +
                ", currentPage=" + currentPage +
                ", rowCount=" + rowCount +
                '}';
    }

    public String toJSONString() {
        return JSON.toJSONString(this);
    }

    public JSONObject toJSONObject() {
        return JSON.parseObject(this.toJSONString());
    }
}
