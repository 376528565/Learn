package com.designPattern.create.builder.demo2;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: LQL
 * @Date: 2025/01/13
 * @Description:
 */
@Data
@AllArgsConstructor
public class SmallLz implements Lz{

    private double price;
    private String name;

    @Override
    public void lzInfo() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "SmallLz{" +
                "price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}
