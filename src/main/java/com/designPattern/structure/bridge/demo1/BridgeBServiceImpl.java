package com.designPattern.structure.bridge.demo1;

import lombok.AllArgsConstructor;

/**
 * @Author: LQL
 * @Date: 2024/09/10
 * @Description:
 */
@AllArgsConstructor
public class BridgeBServiceImpl implements BridgeBService{

    private BridgeAService bridgeAService;

    @Override
    public void dealB(String data) {
        System.out.println("is b deal: " + data);
        bridgeAService.dealA(data);
    }
}
