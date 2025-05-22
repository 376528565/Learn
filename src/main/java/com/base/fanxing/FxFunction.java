package com.base.fanxing;

/**
 * @Author: LQL
 * @Date: 2024/09/20
 * @Description:
 */
public class FxFunction<T> {

    public <T> T dealData(Class<T> t,T value) throws InstantiationException, IllegalAccessException {
        if (t.getName().equals(String.class.getName()))
            System.out.println("t class type is : String value is : " + value);
        return t.newInstance();
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        FxFunction<String> fxFunction = new FxFunction<>();
        String s = fxFunction.dealData(String.class,"alen");
        System.out.println(s);
    }

}
