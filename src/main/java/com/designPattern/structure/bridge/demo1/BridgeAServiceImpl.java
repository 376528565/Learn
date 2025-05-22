package com.designPattern.structure.bridge.demo1;

/**
 * @Author: LQL
 * @Date: 2024/09/10
 * @Description:
 */
public class BridgeAServiceImpl implements BridgeAService{
    @Override
    public void dealA(String data) {
        System.out.println("is a deal: " + data);
    }
}
