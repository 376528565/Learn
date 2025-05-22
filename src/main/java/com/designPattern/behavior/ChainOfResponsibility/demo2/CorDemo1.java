package com.designPattern.behavior.ChainOfResponsibility.demo2;

/**
 * @Author: LQL
 * @Date: 2024/11/07
 * @Description:
 */
public class CorDemo1 {

    public static void main(String[] args) {
        CorChain link = CorChain.link(new OneNode(), new TwoNode());
        System.out.println("cor deal data: " + link.dealData("alen"));
    }

}
