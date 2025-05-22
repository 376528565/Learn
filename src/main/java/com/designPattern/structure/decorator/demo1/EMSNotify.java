package com.designPattern.structure.decorator.demo1;

/**
 * @Author: LQL
 * @Date: 2025/03/31
 * @Description:
 */
public class EMSNotify extends NotifyDecorator{
    public EMSNotify(Notify notify) {
        super(notify);
    }

    @Override
    public void sendMSG() {
        super.sendMSG();
        System.out.println("ems send msg...");
    }
}
