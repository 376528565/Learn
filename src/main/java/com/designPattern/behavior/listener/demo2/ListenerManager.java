package com.designPattern.behavior.listener.demo2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListenerManager {

    private Map<String, List<Notify>> listenerMap = new HashMap<>();

    public ListenerManager(String... types){
        for (String type : types)
            listenerMap.put(type,new ArrayList<>());
    }

    public void subscriber(String type,Notify notify){
        List<Notify> notifies = listenerMap.get(type);
        notifies.add(notify);
    }

    public void unSubscriber(String type,Notify notify){
        List<Notify> notifies = listenerMap.get(type);
        notifies.remove(notify);
    }

    public void sendMsg(String type,String data){
        List<Notify> notifies = listenerMap.get(type);
        for (Notify notify : notifies){
            notify.update(type,data);
        }
    }

}
