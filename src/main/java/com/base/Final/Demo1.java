package com.base.Final;

/**
 * @Author: LQL
 * @Date: 2024/09/20
 * @Description:
 */
public class Demo1 extends FinalDemo{
    @Override
    public void dealData2(String data) {
        System.out.println("demo1 deal data: " + data);
    }

    public String deal(String data){
        try {
            System.out.println("data");
            return "alen";
        }finally {
            System.out.println("finally deal");
        }
    }

    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();
        System.out.println(demo1.deal("alen"));

    }
}
