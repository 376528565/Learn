package com.designPattern.create.SimpleFactory.demo2;

/**
 * @Author: LQL
 * @Date: 2024/11/28
 * @Description:
 */
public class AnimalFactory {

    public Animal getInstance(String type){
        if ("cat".equals(type))
            return new Cat();
        else if ("pig".equals(type))
            return new Pig();
        else
            return null;
    }

}
