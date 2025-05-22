package com.base.InnerClass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: LQL
 * @Date: 2024/06/20
 * @Description:
 */
public class InnerClass {

    /**
     * 为什么要使用内部类而不是外部类？
     * 虽然外部类可以实现许多相同的功能，但内部类在以下方面提供了独特的优势：
     * 封装性和逻辑分组：内部类可以将辅助类封装在外部类中，体现逻辑包含关系。
     * 访问外部类成员：内部类可以直接访问外部类的成员，包括私有成员。
     * 简化回调机制：在事件驱动编程中，内部类可以简化回调机制。
     * 代码简洁性和模块化：内部类可以帮助将相关代码分组在一起，增加模块化和简洁性。
     * 接口的特定实现：内部类可以在一个类中提供多个接口的实现，而无需使用多个类。
     * 因此，在特定情况下，内部类可以提高代码的可读性、可维护性和灵活性
     */

    //封装性和逻辑分组：内部类可以将辅助类封装在外部类中，体现逻辑包含关系。
    private List<Node> nodes;
    private InnerClass2 innerClass2;


    public InnerClass(){
        this.nodes = new ArrayList<>();
        this.innerClass2 = new InnerClass2();
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class Node{
        private String key;
        private String value;
    }


    //访问外部类成员：内部类可以直接访问外部类的成员，包括私有成员。
    private static volatile int outValue = 10;

    public class InnerClass2{
        private int value = outValue;

        public void func1(){
            System.out.println("inner class2 value: " + value);
            outValue = 11;
        }

    }

    //简化回调机制：在事件驱动编程中，内部类可以简化回调机制。
    public void outFunc1(){
        innerClass2.func1();
        System.out.println("outValue is : " + outValue);
    }

    public static void main(String[] args) {
        InnerClass innerClass = new InnerClass();
        innerClass.outFunc1();
    }




}
