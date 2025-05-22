package com.designPattern.create.AbstructFactory.demo2;

/**
 * @Author: LQL
 * @Date: 2024/11/28
 * @Description:
 */
public class AbstractAnimalFactory {

    private Dog dog;
    private Cat cat;

    public AbstractAnimalFactory(Dog dog, Cat cat){
        this.dog = dog;
        this.cat = cat;
    }

    public void doSomething(){
        dog.bark();
        cat.sleep();
    }

}
