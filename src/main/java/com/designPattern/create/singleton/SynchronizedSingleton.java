package com.designPattern.create.singleton;

/**
 * @Author: LQL
 * @Date: 2024/09/02
 * @Description:
 */
public class SynchronizedSingleton {

    private String name;
    private static volatile SynchronizedSingleton instance;

    private SynchronizedSingleton(){}

    public static SynchronizedSingleton getInstance(){
        if (instance == null){
            synchronized (SynchronizedSingleton.class){
                if (instance == null)
                    instance = new SynchronizedSingleton();
            }
        }
        return instance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
