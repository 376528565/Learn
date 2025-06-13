package com.base.jicheng;

/**
 * @Author: LQL
 * @Date: 2025/06/04
 * @Description:
 */
public class Son1 extends Parent{

    /**
     * 对父类中方法进行重写后，在通过上转型构建类实例对象并调用父类方法时，如果该方法中调用了
     * 重写的方法，则该方法调用的是子类的。
     */
    @Override
    public void deal2() {
        System.out.println("son1 deal2...");
    }
}
