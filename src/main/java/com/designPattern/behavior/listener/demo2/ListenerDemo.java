package com.designPattern.behavior.listener.demo2;

/**
 * @Author: LQL
 * @Date: 2024/12/09
 * @Description:
 */
public class ListenerDemo {

    public static void main(String[] args) {
        Notifier notifier = new Notifier();
        notifier.listenerManager = new ListenerManager("send1","send2");
        notifier.listenerManager.subscriber("send1",new QQNotifyListener());
        notifier.listenerManager.subscriber("send2",new EMSNotifyListener());
        notifier.send1("alen");
        System.out.println("-----------");
        notifier.send2("bella");
    }

}
