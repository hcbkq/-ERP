package com.zhang.rep.entity.hp;

import org.apache.poi.ss.formula.functions.T;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PageInformation {
    private Integer pageCount;
    private Integer libraryPageNo;
    private Integer displayPageNo;
    private List<Object> list;

    @Override
    public String toString() {
        return "PageInformation{" +
                "pageCount=" + pageCount +
                ", libraryPageNo=" + libraryPageNo +
                ", displayPageNo=" + displayPageNo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PageInformation that = (PageInformation) o;
        return Objects.equals(pageCount, that.pageCount) && Objects.equals(libraryPageNo, that.libraryPageNo) && Objects.equals(displayPageNo, that.displayPageNo) && Objects.equals(list, that.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pageCount, libraryPageNo, displayPageNo, list);
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getLibraryPageNo() {
        return libraryPageNo;
    }

    public void setLibraryPageNo(Integer libraryPageNo) {
        this.libraryPageNo = libraryPageNo;
    }

    public Integer getDisplayPageNo() {
        return displayPageNo;
    }

    public void setDisplayPageNo(Integer displayPageNo) {
        this.displayPageNo = displayPageNo;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }
}
