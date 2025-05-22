package com.designPattern.create.builder.demo1;

/**
 * @Author: LQL
 * @Date: 2025/05/20
 * @Description:
 */
public class Userss {

    private final String name;
    private final String address;

    @Override
    public String toString() {
        return "Userss{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    private Userss(Builder builder){
        this.name = builder.name;
        this.address = builder.address;
    }

    public static class Builder{
        private String name;
        private String address = "";

        public Builder name(String name){
            this.name = name;
            return this;
        }
        public Builder address(String address){
            this.address = address;
            return this;
        }

        public Userss builder(){
            return new Userss(this);
        }

    }


}
