package com.base.Interface;

/**
 * @Author: LQL
 * @Date: 2024/09/20
 * @Description: 接口中默认方法，实现类可以不实现
 */
public interface Demo1Interface {

    //接口中定义的是静态常量,而在枚举中定义的是静态实例 RED("red",123); 这里是通过实例对象将静态存储到枚举类中作为静态实例
    public static final char A = '1';
    void deal(String data);

    default void deal2(String data){
        System.out.println("interface deal data");
    }

}
