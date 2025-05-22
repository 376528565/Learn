package com.designPattern.behavior.listener.demo2;

/**
 * @Author: LQL
 * @Date: 2024/12/09
 * @Description:
 */
public class QQNotifyListener implements Notify{
    @Override
    public void update(String type, String data) {
        System.out.println("qq send type is : " + type + " data is : " + data);
    }
}
