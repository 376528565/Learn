package com.designPattern.structure.decorator.demo1;

/**
 * @Author: LQL
 * @Date: 2025/03/31
 * @Description:
 */
public class QQNotify extends NotifyDecorator{
    public QQNotify(Notify notify) {
        super(notify);
    }

    @Override
    public void sendMSG() {
        super.sendMSG();
        System.out.println("qq send Notify...");
    }
}
