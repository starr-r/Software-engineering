package com.example.demo.common;

public enum ResultCode {
    SUCCESS("0", "成功"),
    ERROR("-1", "系统异常"),
    USER_EXIST_ERROR("201", "用户名已被使用"),
    USER_ACCOUNT_ERROR("301", "账号或密码错误"),
            ;

    public String code;
    public String msg;

    ResultCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
