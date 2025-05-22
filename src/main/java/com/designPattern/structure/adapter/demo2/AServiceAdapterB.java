package com.designPattern.structure.adapter.demo2;

import lombok.AllArgsConstructor;

/**
 * @Author: LQL
 * @Date: 2024/11/20
 * @Description:
 */
@AllArgsConstructor
public class AServiceAdapterB extends AServiceImpl{

    private BService bService;

    public void dealData(){
        bService.dealDataB();
        super.dealData();
        System.out.println("aService adapter bService");
    }

    public static void main(String[] args) {
        AServiceAdapterB aServiceAdapterB = new AServiceAdapterB(new BServiceImpl());
        aServiceAdapterB.dealData();
    }

}
