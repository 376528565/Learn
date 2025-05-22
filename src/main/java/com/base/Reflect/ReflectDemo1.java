package com.base.Reflect;

import com.base.Static.StaticDemo1;
import com.base.paramRange.AClass;
import lombok.Data;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author: LQL
 * @Date: 2024/09/20
 * @Description:
 */
public class ReflectDemo1 {

    /**
     * Class 和 java.lang.reflect 一起对反射提供了支持，java.lang.reflect 类库主要包含了以下三个类:
     * Field : 可以使用 get() 和 set() 方法读取和修改 Field 对象关联的字段；
     * Method : 可以使用 invoke() 方法调用与 Method 对象关联的方法；
     * Constructor : 可以用 Constructor 创建新的对象。
     */

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        Class<?> aClass = Class.forName("com.base.Reflect.ReflectDemo2");
        ReflectDemo2 object = (ReflectDemo2)aClass.newInstance();
        object.func1("alen");
//        Class<StaticDemo1> staticDemo1Class = StaticDemo1.class;
//        Method method = staticDemo1Class.getMethod("deal", String.class);
////        Data annotation = staticDemo1Class.getAnnotation(Data.class);
////        System.out.println("annotation value is : " + annotation.staticConstructor());
//        StaticDemo1 staticDemo1 = staticDemo1Class.newInstance();
//        method.invoke(staticDemo1,"alen");
//        System.out.println(staticDemo1.getName());
    }

}
