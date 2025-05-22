package com.designPattern.behavior.listener.demo1;

/**
 * @Author: LQL
 * @Date: 2025/02/08
 * @Description:
 */
public class ListenerDemo {

    public static void main(String[] args) {
        SendListener sendListener = new SendListener();
        sendListener.listenerManager.subscriber("qq",new Service1());
        sendListener.listenerManager.subscriber("qq",new Service2());
        sendListener.sendQQ("alen");
        sendListener.sendEMS("bella");
    }

}
