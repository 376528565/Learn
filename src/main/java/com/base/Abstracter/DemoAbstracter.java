package com.base.Abstracter;

/**
 * @Author: LQL
 * @Date: 2025/02/11
 * @Description:
 */
public abstract class DemoAbstracter {

    protected void deal1(){
        System.out.println("deal1 deal....");
    }

    public abstract void deal2();

    protected void deal(){
        this.deal1();
        this.deal2();
    }

}
