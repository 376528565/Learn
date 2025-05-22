package com.base.Final;

import com.base.paramRange.AClass;

/**
 * @Author: LQL
 * @Date: 2024/09/20
 * @Description: 声明类为final，该类无法被继承（可以通过组合、聚合实现方法的重写）
 */
public class FinalDemo {

    /**
     * 声明参数是常量，可以是编译时常量，也可以是在运行时被初始化后不能被改变的常量
     * 对于基本类型，final 使数值不变；
     * 对于引用类型，final 使引用不变，也就不能引用其它对象，但是被引用的对象本身是可以修改的
     * 常量折叠：
     * 在类加载的编译阶段：
     * final a = 1;
     * final b = 2;
     * final c = a + b; //此时c就会出发编译期的常量折叠，直接编译为：final c = 3;
     */

    //final方法不能被子类重写
    public final void dealData(String data){
        System.out.println("final deal: " + data);
    }

    public void dealData2(String data){
        System.out.println("final deal data2: " + data);
    }

}
