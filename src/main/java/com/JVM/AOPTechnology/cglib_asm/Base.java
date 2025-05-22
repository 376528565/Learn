package com.JVM.AOPTechnology.cglib_asm;

/**
 * @Author: LQL
 * @Date: 2024/07/22
 * @Description:
 */
public class Base {


    /**
     * 对于需要手动操纵字节码的需求，可以使用ASM，它可以直接生产 .class字节码文件，
     * 也可以在类被加载入JVM之前动态修改类行为。ASM的应用场景有AOP（Cglib就是基于ASM）、
     * 热部署、修改其他jar包中的类等。当然，涉及到如此底层的步骤，实现起来也比较麻烦。
     */

    public void func1(){
        System.out.println("deal func1");
    }

}
