package com.jnshu.crq.common;

import org.springframework.stereotype.Component;

/**
 * @title:页面类来存储页面信息
 * @author:crq131290
 * @Description:ToDo
 * @Date:2019/07/23
 * */
@Component
public class Page {
    private int currentPage=1;//当前页数
    private int total; //总页数
    private int totalStudets; //记录总行数
    private int pageSize;//每页记录行数
    private int nextPage; //下一页
    private int prePage; //前一页


    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotal() {
        total = totalStudets % pageSize ==0? totalStudets/pageSize:totalStudets/pageSize+1;
        return total;
    }

    public int getTotalStudets() {
        return totalStudets;
    }

    public void setTotalStudets(int totalStudets) {
        this.totalStudets = totalStudets;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getNextPage() {
        nextPage = currentPage<totalStudets ? currentPage+1 : currentPage;
        return nextPage;
    }

    public int getPrePage() {
        prePage = currentPage>1 ? prePage-1:prePage;
        return prePage;
    }
}
