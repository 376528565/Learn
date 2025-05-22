package com.designPattern.behavior.listener.demo1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: LQL
 * @Date: 2025/02/08
 * @Description:
 */
public class ListenerManager {

    private Map<String, List<ListenerService>> listenerServiceMap = new HashMap<>();

    public ListenerManager(String... keys){
        for (String key : keys)
            listenerServiceMap.put(key,new ArrayList<>());
    }

    public void subscriber(String key,ListenerService listenerService){
        List<ListenerService> listenerServices = listenerServiceMap.get(key);
        listenerServices.add(listenerService);
    }

    public void unSubscriber(String key,ListenerService listenerService){
        listenerServiceMap.get(key).remove(listenerService);
    }

    public void sendMsg(String key,String data){
        List<ListenerService> listenerServices = listenerServiceMap.get(key);
        listenerServices.forEach(item -> item.deal(data));
    }

}
