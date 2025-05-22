package com.designPattern.create.singleton.demo1;

/**
 * @Author: LQL
 * @Date: 2025/01/08
 * @Description:
 */
public class SyncSingleton {

    private SyncSingleton syncSingleton;

    private SyncSingleton(){}

    public SyncSingleton getSyncSingleton(){
        if (null == syncSingleton){
            synchronized(SyncSingleton.class){
                if (null == syncSingleton)
                    syncSingleton = new SyncSingleton();
            }
        }
        return syncSingleton;
    }
}
