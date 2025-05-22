package com.designPattern.structure.bridge.demo;

/**
 * @Author: LQL
 * @Date: 2025/03/31
 * @Description:
 */
public class BridgeDemo {

    public static void main(String[] args) {
        ColorAndShapeBridge bridge = new ColorAndShapeBridge(new Red(), new Circle());
        bridge.info();
    }

}
