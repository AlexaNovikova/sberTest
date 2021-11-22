package com.sb.interview.utils;

import java.util.Date;

public class Key {

    private final Long id;
    private Date mutableDate;

    public Key(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Date getMutableDate() {
        return mutableDate;
    }

    public void setMutableDate(Date mutableDate) {
        this.mutableDate = mutableDate;
    }
}
