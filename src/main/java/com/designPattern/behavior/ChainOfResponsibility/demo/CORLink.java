package com.designPattern.behavior.ChainOfResponsibility.demo;

import lombok.NoArgsConstructor;

/**
 * @Author: LQL
 * @Date: 2025/03/31
 * @Description:
 */
@NoArgsConstructor
public abstract class CORLink {

    private CORLink next;

    public static CORLink link(CORLink first,CORLink... links){
        CORLink head = first;
        for (CORLink link : links){
            head.next = link;
            head = link;
        }
        return first;
    }

    public abstract String deal(String data);

    public String getNext(String data){
        if (this.next == null)
            return data;
        return this.next.deal(data);
    }


}
