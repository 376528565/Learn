package com.designPattern.create.builder.demo2;

/**
 * @Author: LQL
 * @Date: 2025/01/13
 * @Description:
 */
public class AudiCar implements CarBuilder{

    private Engine engine;
    private Lz lz;

    @Override
    public void createLz(Lz lz) {
        this.lz = lz;
    }

    @Override
    public void createEngine(Engine engine) {
        this.engine = engine;
    }

    public void showCar(){
        System.out.println("show car info : ");
        this.engine.engineInfo();
        this.lz.lzInfo();
    }
}
