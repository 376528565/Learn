package com.JVM;

/**
 * @Author: LQL
 * @Date: 2024/07/22
 * @Description:
 */
public class ClassFile {


    /**
     * 通过 javac *.java 编译成字节码文件
     * 通过javap -v -p *.class 反编译字节码文件
     */

    private Integer key;

    public int func(){
        return key + 1;
    }

}
