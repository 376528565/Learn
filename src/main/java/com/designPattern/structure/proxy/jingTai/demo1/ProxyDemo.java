package com.designPattern.structure.proxy.jingTai.demo1;

/**
 * @Author: LQL
 * @Date: 2025/01/08
 * @Description:
 */
public class ProxyDemo {

    public static void main(String[] args) {
        EnhanceProxy enhanceProxy = new EnhanceProxy(new StaticProxyDemo());
        enhanceProxy.enhanceDeal();
    }

}
