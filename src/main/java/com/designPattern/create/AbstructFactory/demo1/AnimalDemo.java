package com.designPattern.create.AbstructFactory.demo1;

/**
 * @Author: LQL
 * @Date: 2024/08/16
 * @Description:
 */
public class AnimalDemo {

    public static void main(String[] args) {
        AnimalApplication animalApplication = new AnimalApplication(new AAnimalFactory());
        animalApplication.bark();
        animalApplication.sleep();
    }

}
