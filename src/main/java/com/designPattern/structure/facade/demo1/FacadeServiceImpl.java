package com.designPattern.structure.facade.demo1;

/**
 * @Author: LQL
 * @Date: 2024/11/28
 * @Description:
 */
public class FacadeServiceImpl implements Facade{
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
