package com.designPattern.create.singleton.demo1;

/**
 * @Author: LQL
 * @Date: 2025/01/08
 * @Description:
 */
public class LazySingleton {

    private LazySingleton lazySingleton;

    private LazySingleton(){}

    public LazySingleton getInstance(){
        if (null == lazySingleton)
            lazySingleton = new LazySingleton();
        return lazySingleton;
    }

}
