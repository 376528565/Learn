package com.designPattern.structure.bridge.demo1;

/**
 * @Author: LQL
 * @Date: 2024/09/10
 * @Description:
 */
public class BridgeA1ServiceImpl implements BridgeAService{
    @Override
    public void dealA(String data) {
        System.out.println("is a1 deal: " + data);
    }
}
