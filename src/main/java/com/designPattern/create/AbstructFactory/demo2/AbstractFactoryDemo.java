package com.designPattern.create.AbstructFactory.demo2;

import com.designPattern.create.SimpleFactory.demo2.AnimalFactory;

/**
 * @Author: LQL
 * @Date: 2024/11/28
 * @Description:
 */
public class AbstractFactoryDemo {

    public static void main(String[] args) {
        AbstractAnimalFactory animal = new AbstractAnimalFactory(new BigDog(), new LittleCat());
        animal.doSomething();
    }

}
