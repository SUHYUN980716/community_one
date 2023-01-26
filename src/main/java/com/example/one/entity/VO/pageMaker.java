package com.example.one.entity.VO;

public class pageMaker {
    private Criteria cri;
    private int totalCount;
    private int startPage;
    private int endPage;
    private boolean prev;
    private boolean next;
    private int displayPageNum = 5;

    public Criteria getCri() {
        return cri;
    }
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        makePaging();
    }

    private void makePaging() {
        endPage = (int)(Math.ceil(cri.getPage()/(double)displayPageNum)*displayPageNum);
        startPage = (endPage-displayPageNum)+1;
        if(startPage<0) startPage=1;
        int tempEndPage=(int)(Math.ceil(totalCount/(double)cri.getPerPageNum()));
        if(tempEndPage<endPage){
            endPage = tempEndPage;
        }

        prev= (startPage==1) ? false : true;
        next= (endPage<tempEndPage) ? true : false;
    }

    public pageMaker setCri(Criteria cri) {
        this.cri = cri;
        return this;
    }

    public int getTotalCount() {
        return totalCount;
    }


    public int getStartPage() {
        return startPage;
    }

    public pageMaker setStartPage(int startPage) {
        this.startPage = startPage;
        return this;
    }

    public int getEndPage() {
        return endPage;
    }

    public pageMaker setEndPage(int endPage) {
        this.endPage = endPage;
        return this;
    }

    public boolean isPrev() {
        return prev;
    }

    public pageMaker setPrev(boolean prev) {
        this.prev = prev;
        return this;
    }

    public boolean isNext() {
        return next;
    }

    public pageMaker setNext(boolean next) {
        this.next = next;
        return this;
    }

    public int getDisplayPageNum() {
        return displayPageNum;
    }

    public pageMaker setDisplayPageNum(int displayPageNum) {
        this.displayPageNum = displayPageNum;
        return this;
    }


}
