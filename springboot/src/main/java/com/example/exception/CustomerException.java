package com.example.exception;
//自定义异常，运行时一次
public class CustomerException extends RuntimeException {
    public String code;
    public String msg;
    public CustomerException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public CustomerException(String msg) {
        this.msg = msg;
        this.code = "500";
    }
    public CustomerException() {}
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
