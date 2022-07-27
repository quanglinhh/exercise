package com.example.springboot.controller.dto;

import com.example.springboot.model.TblUser;

import java.util.List;

public class ListUser {
    private List<TblUser> data;

    public List<TblUser> getData() {
        return data;
    }

    public void setData(List<TblUser> data) {
        this.data = data;
    }
}
