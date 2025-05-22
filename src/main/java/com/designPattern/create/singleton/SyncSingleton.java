package com.designPattern.create.singleton;

/**
 * @Author: LQL
 * @Date: 2024/08/15
 * @Description:
 */
public class SyncSingleton {

    private volatile static SyncSingleton syncSingleton;

    private SyncSingleton(){

    }

    public static SyncSingleton getInstance(){
        if (null == syncSingleton){
            synchronized (SyncSingleton.class){
                if (null == syncSingleton)
                    syncSingleton = new SyncSingleton();
            }
        }
        return syncSingleton;
    }

}
