package com.jnshu.crq.page;

public class Page {
    private int currentPage = 1;
    private int total;
    private int totalRecords;
    private int pageSize;
    private int nextPage;
    private int prePage;



    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageSize() {
        return pageSize;
    }


    public int getNextPage() {
        nextPage = currentPage<totalRecords ? currentPage+1 : currentPage;
        return nextPage;
    }

    public int getPrePage() {
        prePage = currentPage>1?currentPage-1:currentPage;
        return prePage;
    }

    public int getTotal() {
        int isZero = this.totalRecords % this.pageSize;
        int total = this.totalRecords / this.pageSize;
        return isZero==0 ? total : total+1;
    }




}
