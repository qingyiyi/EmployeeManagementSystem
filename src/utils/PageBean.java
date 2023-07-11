package edu.ustb.manager.utils;

import java.util.List;

public class PageBean <T>{  //��ʽ���
    //��ǰҳ��
    private int pageIndex;
    //ÿҳ��¼��
    private int pageRecord;
    //��ҳ��
    private int pageCount;
    //�ܼ�¼��
    private int totalRecord;

    private List<T> resultList;

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageRecord() {
        return pageRecord;
    }

    public void setPageRecord(int pageRecord) {
        this.pageRecord = pageRecord;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public List<T> getResultList() {
        return resultList;
    }

    public void setResultList(List<T> resultList) {
        this.resultList = resultList;
    }
}
