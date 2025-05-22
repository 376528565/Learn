package com.designPattern.structure.decorator.demo1;

import lombok.AllArgsConstructor;

/**
 * @Author: LQL
 * @Date: 2025/03/31
 * @Description:
 */
@AllArgsConstructor
public class NotifyDecorator implements Notify{

    private Notify notify;

    @Override
    public void sendMSG() {
        notify.sendMSG();
    }
}
