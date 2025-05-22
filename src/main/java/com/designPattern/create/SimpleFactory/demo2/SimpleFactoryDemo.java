package com.designPattern.create.SimpleFactory.demo2;

/**
 * @Author: LQL
 * @Date: 2024/11/28
 * @Description:
 */
public class SimpleFactoryDemo {

    public static void main(String[] args) {
        AnimalFactory animalFactory = new AnimalFactory();
        Animal animal = animalFactory.getInstance("cat");
        animal.deal();
    }

}
