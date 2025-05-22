package com.designPattern.behavior.TemplateMethod;

/**
 * @Author: LQL
 * @Date: 2024/08/22
 * @Description:
 */
public abstract class TemplateMethodAbstract {

    public final String dealData(String data){
        String rst = null;
        if ((rst = func1(data)).equals("success"))
            if ((rst = hook(data)).equals("success"))
                if ((rst = func2(data)).equals("success"))
                    return "success";
        return rst;
    }

    public abstract String func1(String data);
    public abstract String func2(String data);

    public String hook(String data){
        System.out.println("default hook deal");
        return "success";
    }

}
