package com.designPattern.behavior.ChainOfResponsibility.demo2;

/**
 * @Author: LQL
 * @Date: 2024/11/07
 * @Description:
 */
public abstract class CorChain {

    private CorChain next;

    public static CorChain link(CorChain first,CorChain... corChains){
        CorChain head = first;
        for (CorChain item : corChains){
            head.next = item;
            item = head;
        }
        return first;
    }

    public abstract String dealData(String data);

    public String getNext(String data){
        if (this.next == null)
            return data;
        return this.next.dealData(data);
    }

}
