package com.designPattern.create.AbstructFactory.demo1;

/**
 * @Author: LQL
 * @Date: 2024/08/16
 * @Description:
 */
public class AAnimalFactory implements AnimalFactory{
    @Override
    public Dog createDog() {
        return new ADog();
    }

    @Override
    public Cat createCat() {
        return new ACat();
    }
}
