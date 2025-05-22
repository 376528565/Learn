package com.base.Reflect;

import lombok.Data;

import java.lang.annotation.Annotation;

/**
 * @Author: LQL
 * @Date: 2024/10/24
 * @Description:
 */
public class ReflectDemo2 {

    public static void main(String[] args) {
        SysUser sysUser = new SysUser("alen", "beijing", 12);
        Class<? extends SysUser> aClass = sysUser.getClass();
        Annotation[] annotations = aClass.getAnnotations();
        System.out.println("deal");
    }

    public void func1(String name){
        System.out.println("name is " + name);
    }

}
