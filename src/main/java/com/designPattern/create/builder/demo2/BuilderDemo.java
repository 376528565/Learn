package com.designPattern.create.builder.demo2;

/**
 * @Author: LQL
 * @Date: 2025/01/13
 * @Description:
 */
public class BuilderDemo {

    public static void main(String[] args) {
        AudiCar audiCar = new AudiCar();
        audiCar.createEngine(new Engine1(13.33,"one"));
        audiCar.createLz(new SmallLz(33,"audi"));
        audiCar.showCar();
    }

}
