package com.designPattern.structure.adapter.demo1;

/**
 * @Author: LQL
 * @Date: 2025/03/31
 * @Description:
 */
public class AdapterDemo1 {

    public static void main(String[] args) {
        Adapter2Adapter1 adapter2 = new Adapter2Adapter1(new Adapter1ServiceImpl1());
        adapter2.deal2();
    }

}
