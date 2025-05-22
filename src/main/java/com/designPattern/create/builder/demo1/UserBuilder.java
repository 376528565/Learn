package com.designPattern.create.builder.demo1;

/**
 * @Author: LQL
 * @Date: 2025/05/20
 * @Description:
 */
public class UserBuilder {

    public static void main(String[] args) {
        Userss builder = new Userss.Builder()
                .name("alen")
                .address("cq")
                .builder();
        System.out.println(builder.toString());
    }

}
