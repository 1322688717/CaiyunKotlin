package com.example.caiyunkotlin.bean;

import com.google.gson.annotations.SerializedName;

public class BeanLogout {

    @SerializedName("msg")
    private String msg;
    @SerializedName("code")
    private Integer code;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
