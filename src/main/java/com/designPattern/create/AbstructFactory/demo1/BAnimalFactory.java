package com.designPattern.create.AbstructFactory.demo1;

/**
 * @Author: LQL
 * @Date: 2024/08/16
 * @Description:
 */
public class BAnimalFactory implements AnimalFactory{
    @Override
    public Dog createDog() {
        return new BDog();
    }

    @Override
    public Cat createCat() {
        return new BCat();
    }
}
