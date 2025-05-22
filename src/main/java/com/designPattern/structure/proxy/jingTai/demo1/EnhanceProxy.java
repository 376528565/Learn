package com.designPattern.structure.proxy.jingTai.demo1;

import lombok.AllArgsConstructor;

/**
 * @Author: LQL
 * @Date: 2025/01/08
 * @Description:
 */
@AllArgsConstructor
public class EnhanceProxy {

    private StaticProxy staticProxy;

    public void enhanceDeal(){
        System.out.println("before deal...");
        staticProxy.deal();
        System.out.println("after deal...");
    }

}
