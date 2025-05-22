package com.exception;

/**
 * @Author: LQL
 * @Date: 2025/01/20
 * @Description:
 */
public class AppException extends RuntimeException{

    private String msg;
    private int code;

    public AppException(String msg,int code){
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }
}
