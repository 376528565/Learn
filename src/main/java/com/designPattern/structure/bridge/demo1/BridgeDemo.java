package com.designPattern.structure.bridge.demo1;

/**
 * @Author: LQL
 * @Date: 2024/09/10
 * @Description:
 */
public class BridgeDemo {

    public static void main(String[] args) {
        BridgeBServiceImpl bridgeBService = new BridgeBServiceImpl(new BridgeA1ServiceImpl());
        bridgeBService.dealB("alen");
    }

}
