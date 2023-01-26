package com.example.one.entity.VO;

public class Criteria {
    private int page;
    private int perPageNum;
    public Criteria(){
        this.page = 1;
        this.perPageNum = 5;
    }
    public int getPageStart(){
        return (page-1)*perPageNum;
    }

    public int getPage() {
        return page;
    }

    public Criteria setPage(int page) {
        this.page = page;
        return this;
    }

    public int getPerPageNum() {
        return perPageNum;
    }

    public Criteria setPerPageNum(int perPageNum) {
        this.perPageNum = perPageNum;
        return this;
    }
}
