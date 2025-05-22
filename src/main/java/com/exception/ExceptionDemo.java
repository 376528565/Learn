package com.exception;

/**
 * @Author: LQL
 * @Date: 2025/04/14
 * @Description:
 */
public class ExceptionDemo {

    public static void main(String[] args) {
        ExceptionDemo exceptionDemo = new ExceptionDemo();
        exceptionDemo.deal1();
    }

    public void deal1(){
        try {
            int a = 1 / 0;
            System.out.println(a);
        }catch (RuntimeException e){
            throw new AppException("系统异常: " + e,501);
        }
    }

}
