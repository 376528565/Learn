package com.JVM.classLoad;

/**
 * @Author: LQL
 * @Date: 2024/07/22
 * @Description:
 */
public class ClassLoadDemo {

    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader classLoader = DemoA.class.getClassLoader();
        System.out.println(classLoader);

        Class<?> aClass = Class.forName("com.JVM.classLoad.DemoA");
        System.out.println(aClass.getSimpleName());
    }

}
