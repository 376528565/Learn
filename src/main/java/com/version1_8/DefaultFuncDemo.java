package com.version1_8;

/**
 * @Author: LQL
 * @Date: 2024/07/22
 * @Description:
 */
public class DefaultFuncDemo implements A{

    /**
     * 为什么接口要有默认方法这个特性?
     * 首先，之前的接口是个双刃剑，好处是面向抽象而不是面向具体编程，
     * 缺陷是，当需要修改接口时候，需要修改全部实现该接口的类，
     * 目前的java 8之前的集合框架没有foreach方法，
     * 通常能想到的解决办法是在JDK里给相关的接口添加新的方法及实现。
     * 然而，对于已经发布的版本，是没法在给接口添加新方法的同时不影响已有的实现。
     * 所以引进的默认方法。他们的目的是为了解决接口的修改与现有的实现不兼容的问题
     */


    public static void main(String[] args) {
        DefaultFuncDemo defaultFuncDemo = new DefaultFuncDemo();
        defaultFuncDemo.func1();
    }

    @Override
    public String getName() {
        return "bella";
    }
}

interface A{

    String getName();

    default void func1(){
        if ("alen".equals(getName()))
            System.out.println("default func");
        else
            System.out.println("other deal");
    }

}

