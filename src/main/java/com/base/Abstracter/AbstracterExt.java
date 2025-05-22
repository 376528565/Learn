package com.base.Abstracter;

/**
 * @Author: LQL
 * @Date: 2025/02/11
 * @Description:
 */
public class AbstracterExt extends DemoAbstracter{
    @Override
    public void deal2() {
        System.out.println("ext deal2 data...");
    }

    public static void main(String[] args) {
        AbstracterExt abstracterExt = new AbstracterExt();
        abstracterExt.deal();
    }
}
