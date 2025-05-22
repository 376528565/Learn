package com.designPattern.behavior.listener.demo2;

/**
 * @Author: LQL
 * @Date: 2024/12/09
 * @Description:
 */
public class Notifier {

    protected ListenerManager listenerManager;

    public Notifier(){}

    public void send1(String data){
        listenerManager.sendMsg("send1",data);
    }

    public void send2(String data){
        listenerManager.sendMsg("send2",data);
    }

}
