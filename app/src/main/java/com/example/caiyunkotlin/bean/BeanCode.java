package com.example.caiyunkotlin.bean;

public class BeanCode {

    private String msg;
    private String img;
    private Integer code;
    private Boolean captchaOnOff;
    private String uuid;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Boolean getCaptchaOnOff() {
        return captchaOnOff;
    }

    public void setCaptchaOnOff(Boolean captchaOnOff) {
        this.captchaOnOff = captchaOnOff;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
