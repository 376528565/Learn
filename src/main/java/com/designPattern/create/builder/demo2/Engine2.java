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
public class Engine2 implements Engine{

    private String name;

    @Override
    public void engineInfo() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Engine2{" +
                "name='" + name + '\'' +
                '}';
    }
}
