package com.designPattern.behavior.listener.demo1;

/**
 * @Author: LQL
 * @Date: 2025/02/08
 * @Description:
 */
public class SendListener {

    protected ListenerManager listenerManager;

    public SendListener(){
        this.listenerManager = new ListenerManager("qq","ems");
    }

    public void sendQQ(String data){
        this.listenerManager.sendMsg("qq",data);
    }

    public void sendEMS(String data){
        this.listenerManager.sendMsg("ems",data);
    }
}
