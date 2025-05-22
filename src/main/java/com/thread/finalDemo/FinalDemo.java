package com.thread.finalDemo;

/**
 * @Author: LQL
 * @Date: 2025/04/14
 * @Description:
 */
public class FinalDemo {

    public final String deal(String str){
        return str;
    }

    /**
     * final方法重写
     * @param str1
     * @param str2
     * @return
     */
    public final String deal(String str1,String str2){
        return str1 + str2;
    }

}
