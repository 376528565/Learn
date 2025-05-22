package com.base.enums;

//import lombok.Getter;

/**
 * @Author: LQL
 * @Date: 2025/02/11
 * @Description:
 */
//@Getter
public enum AEnum {

    /**
     * 通过编译可以发现，枚举类是静态类，继承Enum，内部的构造函数私有，实例对象都是静态常量
     * 因此在类加载时就已经进行初始化，不存在多线程竞争问题 --更好解决单例模式问题，
     * 解决反射、反序列化破环单例问题：枚举类的反序列化被JVM做了特殊处理:
     * 在普通 Serializable 类的反序列化过程中，JVM 会通过 readObject 方法创建一个新的对象，
     * 但枚举类不走这个流程，而是通过 Enum.valueOf(Class<T>, String) 直接返回枚举实例
     */

    D1("alen");

    private String name;

    private AEnum(String name){
        this.name = name;
    }

}
