package com.collectionContainer.map;

/**
 * @Author: LQL
 * @Date: 2025/03/11
 * @Description:
 */
public class A {

    public void deal(String name){
        System.out.println("a deal : " + name);
        deal1();
        deal2();
    }

    public void deal1(){}

    final void deal2(){
        System.out.println("final deal2...");
    }

}
