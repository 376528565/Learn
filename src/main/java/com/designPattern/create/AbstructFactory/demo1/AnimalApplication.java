package com.designPattern.create.AbstructFactory.demo1;

/**
 * @Author: LQL
 * @Date: 2024/08/16
 * @Description:
 */
public class AnimalApplication {

    private Dog dog;
    private Cat cat;

    public AnimalApplication(AnimalFactory animalFactory){
        this.dog = animalFactory.createDog();
        this.cat = animalFactory.createCat();
    }

    public void bark(){
        dog.bark();
    }

    public void sleep(){
        cat.sleep();
    }

}
