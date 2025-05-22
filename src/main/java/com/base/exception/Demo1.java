package com.base.exception;

/**
 * @Author: LQL
 * @Date: 2025/02/11
 * @Description:
 */
public class Demo1 {

    public static void main(String[] args) {
        System.out.println(Demo1.deal());
    }

    public static String deal(){
        try {
            System.out.println("try ...");
            System.out.println(1 / 0);
            return "alen";
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
            return "bella";
        }finally {
            System.out.println("finally...");
            return "zoy";
        }
    }

}
