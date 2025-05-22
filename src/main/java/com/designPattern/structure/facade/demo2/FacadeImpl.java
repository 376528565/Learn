package com.designPattern.structure.facade.demo2;

/**
 * @Author: LQL
 * @Date: 2025/02/14
 * @Description:
 */
public class FacadeImpl implements Facade{
    @Override
    public void deal1() {
        System.out.println("deal1...");
    }

    @Override
    public void deal2() {
        System.out.println("deal2...");
    }

    @Override
    public void deal3() {
        System.out.println("deal3...");
    }
}
