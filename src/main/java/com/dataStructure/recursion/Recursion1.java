package com.dataStructure.recursion;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: LQL
 * @Date: 2024/12/18
 * @Description: 递归
 */
@Data
@AllArgsConstructor
public class Recursion1 {

    private String name;
    private Recursion1 recursion1;

    public static void main(String[] args) {
        Recursion1 recursion11 = new Recursion1("alen", new Recursion1("bella", new Recursion1("zuoy", null)));
        while (recursion11 != null){
            System.out.println(recursion11.name);
            recursion11 = recursion11.recursion1;
        }
        System.out.println("deal end...");
    }

}
