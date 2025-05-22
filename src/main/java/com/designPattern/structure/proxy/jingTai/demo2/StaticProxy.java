package com.designPattern.structure.proxy.jingTai.demo2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: LQL
 * @Date: 2025/02/14
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StaticProxy {

    private ProxyInterface proxyInterface;

    public void enhanceFunc(){
        System.out.println("before deal...");
        this.proxyInterface.deal();
        System.out.println("after deal...");
    }

    public static void main(String[] args) {
        StaticProxy staticProxy = new StaticProxy(new ProxyDeal());
        staticProxy.enhanceFunc();
    }

}
