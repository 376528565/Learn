package com.base.fanxing;

/**
 * @Author: LQL
 * @Date: 2024/09/20
 * @Description:
 */
public class ClassA<T extends Number> {

    public <T extends Number> double sum(T t1,T t2){
        return t1.doubleValue() + t2.doubleValue();
    }
}
