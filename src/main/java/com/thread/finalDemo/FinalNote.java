package com.thread.finalDemo;

import java.util.Random;

/**
 * @Author: LQL
 * @Date: 2024/06/17
 * @Description:
 */
public class FinalNote {

    /**
     * 所有的final修饰的字段都是编译期常量吗?
     * A;不是：//非编译期常量
     *     Random r = new Random();
     *     final int k = r.nextInt();随机值赋值，所以final并不一定都是编译器常量，只不过在赋值后就无法更改
     * 如何理解private所修饰的方法是隐式的final?
     * A：只能在本类中使用，无法被子类以及其他类使用
     * 说说final类型的类如何拓展? 比如String是final类型，我们想写个MyString复用所有String中方法，
     * 同时增加一个新的toMyString()的方法，应该如何做?
     * A；使用组合实现
     * final方法可以被重载吗? 可以
     * 父类的final方法能不能够被子类重写? 不可以
     * 说说final域重排序规则?-指的是final常量在多线程中的初始化操作，分为读和写重排序
     * 简单来说就是：确保final的初始化操作在类的构造函数完成之前结束
     * A；写final域的重排序规则禁止对final域的写重排序到构造函数之外：意思是对final常量的写在重排序中也会控制在构造函数内
     * 在读一个对象的final域之前，一定会先读这个包含这个final域的对象的引用
     * 对于对象和引用类型的重排序操作都会在构造函数内进行
     * 读和写对分别在读和写操作之前插入loadload屏障和storestore屏障（具体是否插入还是得看是什么处理器）
     * ---------------
     * 说说final的原理?
     * 通过确保final字段在构造函数结束后对其他线程是可见的---确保构造函数执行后-实例对象产生，final的字段对其他线程可见
     * 使用 final 的限制条件和局限性?
     * 当一个基本数据类型被final修饰后，必须在构造函数退出前设置他的值
     * 引用类型被final修改后，只是该引用不可变，类型中的其他属性是可以操作的
     * 看本文最后的一个思考题
     * 1、
     * byte b1=1;
     * byte b2=3;
     * byte b3=b1+b2;
     * 报错：b1和b2在+操作时，被JVM转换成int类型，无法自动将int类型转为byte
     * 2、
     * final byte b1=1;
     * final byte b2=3;
     * byte b3=b1+b2;
     * 正常：使用final时在【编译】阶段已经是有初始值的常量(常量折叠)，累加不会改变类型
     * 常量折叠：在编译阶段对于已经赋值的常量，编译器会对这些常量进行折叠优化，编译器会直接将这部分的值替换到代码中，
     * 具体实现：
     * 编译器看到 final byte b1 = 1; 和 final byte b2 = 3;。
     * 编译器知道 b1 和 b2 是常量，可以在编译时将 b1 + b2 计算为 4。
     * 因此，编译器将生成的字节码会类似于直接将 b3 初始化为 4
     */

    public static void main(String[] args) {
        final int x = new Random().nextInt();
        System.out.println(x);
    }

    public final String func1(String data){
        System.out.println("func1 deal : " + data);
        return data;
    }

    public final String func1(String data,String data1){
        return data;
    }

}
