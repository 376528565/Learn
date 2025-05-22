package com.designPattern.behavior.TemplateMethod.demo1;

/**
 * @Author: LQL
 * @Date: 2025/01/08
 * @Description:
 */
public abstract class TMethod {

    public String deal(String data){
        if (func1(data)){
            if (hook(data)){
                if (func2(data)){
                    return "success";
                }
                return "false";
            }
            return "false";
        }
        return "false";
    }

    public abstract Boolean func1(String data);

    public abstract Boolean func2(String data);

    public Boolean hook(String data){
        System.out.println("模板方法提供钩子方法扩展功能使用...");
        return true;
    }
}
