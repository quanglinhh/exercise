package com.example.studentspringboot.controller.payload;

public class ForexRespondse {
    private float value;

    private String msg;

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
