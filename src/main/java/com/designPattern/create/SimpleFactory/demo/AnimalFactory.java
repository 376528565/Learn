package com.designPattern.create.SimpleFactory.demo;

/**
 * @Author: LQL
 * @Date: 2025/05/20
 * @Description:
 */
public class AnimalFactory {

    private static final String TYPE1 = "alen";
    public static Animal createAnimal(String type){
        return TYPE1.equals(type) ? new Cat() : new Dog();
    }

}
