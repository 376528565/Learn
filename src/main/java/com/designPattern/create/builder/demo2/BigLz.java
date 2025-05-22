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
public class BigLz implements Lz{

    private String name;
    private int num;

    @Override
    public void lzInfo() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "BigLz{" +
                "name='" + name + '\'' +
                ", num=" + num +
                '}';
    }
}
