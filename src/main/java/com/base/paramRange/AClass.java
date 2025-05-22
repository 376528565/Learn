package com.base.paramRange;

/**
 * @Author: LQL
 * @Date: 2024/12/23
 * @Description:
 */
public class AClass {

    private String name;
    protected String address;  //protected类型参数可在子类、不同包中访问
    int age;    // 默认的参数作用范围为同一个包内，无论父子类都能直接访问

}
