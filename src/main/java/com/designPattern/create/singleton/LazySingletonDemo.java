package com.designPattern.create.singleton;

import lombok.Data;

/**
 * @Author: LQL
 * @Date: 2024/09/02
 * @Description:
 */
public class LazySingletonDemo {

    private String name;
    private Integer age;
    private static LazySingletonDemo lazySingletonDemo;
    private LazySingletonDemo(){}

    public static LazySingletonDemo getInstance(){
        if (lazySingletonDemo == null)
            lazySingletonDemo = new LazySingletonDemo();
        return lazySingletonDemo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
