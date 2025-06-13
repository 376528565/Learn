package com.base.jicheng;

/**
 * @Author: LQL
 * @Date: 2025/06/04
 * @Description:
 */
public class Parent {

    public void deal1(){
        System.out.println("parent deal1...");
        deal2();
    }

    public void deal2(){
        System.out.println("parent deal2...");
    }

}
