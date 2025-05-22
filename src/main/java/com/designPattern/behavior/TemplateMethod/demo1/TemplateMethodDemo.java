package com.designPattern.behavior.TemplateMethod.demo1;

/**
 * @Author: LQL
 * @Date: 2025/01/08
 * @Description:
 */
public class TemplateMethodDemo {

    public static void main(String[] args) {
        TMethod tMethod = new T1Method();
        System.out.println(tMethod.deal("alen"));
    }

}
