package com.designPattern.behavior.ChainOfResponsibility.demo;

/**
 * @Author: LQL
 * @Date: 2025/03/31
 * @Description:
 */
public class CORDemo {

    public static void main(String[] args) {
        CORLink corLink = CORLink.link(
                new ONENode(),
                new TWONode()
        );
        System.out.println(corLink.deal("alen"));
    }

}
