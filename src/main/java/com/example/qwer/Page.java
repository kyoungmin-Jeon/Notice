package com.example.qwer;

import lombok.*;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Page<T> {
    private int currentPage;
    private int total;
    private int firstPage;
    private int endPage;
    private int realEnd;
    private List<T> results; // limit offset
    private boolean prev;
    private boolean next;

    public Page(int currentPage, int total, List<T> results) {
        this.currentPage = currentPage;
        this.total = total;
        this.results = results;
        initMethod();
    }

    public void setFirstPage() {
        if (endPage == realEnd)
            firstPage = (endPage / 10) * 10 + 1;
        else
            firstPage = this.endPage - 10 + 1;
    }

    public int getFirstPage() {
        return this.firstPage;
    }

    public void setEndPage() {
        if (currentPage % 10 == 0) {
            endPage = currentPage;
        } else
            endPage = (currentPage / 10 + 1) * 10;

        if (realEnd > endPage)
            endPage = endPage;
        else endPage = realEnd;
    }

    public int getEndPage() {
        return this.endPage;
    }

    public void setRealEnd() {
        if (total % 10 == 0)
            realEnd = total;
        else
            realEnd = total / 10 + 1;
    }

    public int getRealEnd() {
        return this.realEnd;
    }

    public boolean isPrev() {
        if (currentPage != 1)
            return true;
        else return false;
    }

    public boolean isNext() {
        if (currentPage != realEnd)
            return true;
        else return false;
    }

    public void initMethod() {
        setRealEnd();
        setEndPage();
        setFirstPage();
    }
}
