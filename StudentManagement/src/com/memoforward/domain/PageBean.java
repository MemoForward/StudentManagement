package com.memoforward.domain;

import java.util.List;

public class PageBean<T> {
    private List<T> pageList;
    private int totalDataNum;
    private int perPageDataNum;
    private int totalPageNum;
    private int currentPageNum;

    @Override
    public String toString() {
        return "PageBean{" +
                "pageList=" + pageList +
                ", totalDataNum=" + totalDataNum +
                ", perPageDataNum=" + perPageDataNum +
                ", totalPageNum=" + totalPageNum +
                ", currentPageNum=" + currentPageNum +
                '}';
    }

    public List<T> getPageList() {
        return pageList;
    }

    public void setPageList(List<T> pageList) {
        this.pageList = pageList;
    }

    public int getTotalDataNum() {
        return totalDataNum;
    }

    public void setTotalDataNum(int totalDataNum) {
        this.totalDataNum = totalDataNum;
    }

    public int getPerPageDataNum() {
        return perPageDataNum;
    }

    public void setPerPageDataNum(int perPageDataNum) {
        this.perPageDataNum = perPageDataNum;
    }

    public int getTotalPageNum() {
        return totalPageNum;
    }

    public void setTotalPageNum(int totalPageNum) {
        this.totalPageNum = totalPageNum;
    }

    public int getCurrentPageNum() {
        return currentPageNum;
    }

    public void setCurrentPageNum(int currentPageNum) {
        this.currentPageNum = currentPageNum;
    }
}
