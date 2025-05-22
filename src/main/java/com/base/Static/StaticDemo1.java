package com.base.Static;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: LQL
 * @Date: 2024/09/20
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StaticDemo1 {

    /**
     * 静态变量: 又称为类变量，也就是说这个变量属于类的，
     * 类所有的实例都共享静态变量，可以直接通过类名来访问它；静态变量在内存中只存在一份。
     * 实例变量: 每创建一个实例就会产生一个实例变量，它与该实例同生共死
     *
     * 存在继承的情况下，初始化顺序为:
     * 父类(静态变量、静态语句块)
     * 子类(静态变量、静态语句块)
     * 父类(实例变量、普通语句块)
     * 父类(构造函数)
     * 子类(实例变量、普通语句块)
     * 子类(构造函数)
     */

    private String name = "alen";
    private static int age = 2;

    //普通语句块在构建类实例是执行
    {
        System.out.println("simple code block " + this.name);
        System.out.println("simple code block " + this.age);
    }

    static {
        System.out.println(StaticDemo1.age);
    }

    public void deal(String data){
        System.out.println("deal data: " + data);
    }



    public static void main(String[] args) {
        System.out.println("age is : " + age);
        StaticDemo1 staticDemo1 = new StaticDemo1();
        System.out.println("object name : " + staticDemo1.getName());

    }

}
