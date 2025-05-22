package com.designPattern.structure.adapter.demo1;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: LQL
 * @Date: 2025/03/31
 * @Description:
 */
@AllArgsConstructor
@Getter
public class Adapter2Adapter1 implements Adapter2{

    private Adapter1 adapter1;

    @Override
    public void deal2() {
        System.out.println("adapter2 service2 deal...");
        System.out.println("deal adapter1 ...");
        adapter1.deal1();
    }
}
