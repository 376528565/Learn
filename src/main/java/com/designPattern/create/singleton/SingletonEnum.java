package com.designPattern.create.singleton;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Arrays;

/**
 * @Author: LQL
 * @Date: 2025/03/31
 * @Description:
 */
@AllArgsConstructor
@NoArgsConstructor
public enum SingletonEnum {

    ONE("alen",12),
    TWO("bella",11);

    private String name;
    private int age;

    /**
     * 枚举类实现单例模式
     * @param name
     * @return
     */
    public static int getAgeByName(String name){
        SingletonEnum[] values = SingletonEnum.values();
        for (SingletonEnum item : values){
            if (item.name.equals(name))
                return item.age;
        }
        System.out.println("alen....");
        return 0;
    }


}
