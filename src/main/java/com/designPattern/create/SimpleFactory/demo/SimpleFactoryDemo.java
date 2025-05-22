package com.designPattern.create.SimpleFactory.demo;

/**
 * @Author: LQL
 * @Date: 2025/05/20
 * @Description:
 */
public class SimpleFactoryDemo {

    public static void main(String[] args) {
        Animal animal = AnimalFactory.createAnimal("alen");
        animal.bark();
    }

}
