package com.designPattern.structure.decorator.demo2;

/**
 * @Author: LQL
 * @Date: 2025/02/14
 * @Description:
 */
public class EMSNotify extends DecoratorNotify{
    public EMSNotify(Notify notify) {
        super(notify);
    }

    @Override
    public void sendNotify() {
        super.sendNotify();
        System.out.println("ems notify msg...");
    }
}
