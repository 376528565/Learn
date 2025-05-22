package com.designPattern.create.prototype;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

/**
 * @Author: LQL
 * @Date: 2024/09/20
 * @Description: 原型模式-克隆模式(深克隆、浅克隆)
 */
public class PrototypeNote {

    /**
     * 使用 clone() 方法来拷贝一个对象即复杂又有风险，它会抛出异常，并且还需要类型转换。
     * Effective Java 书上讲到，最好不要去使用 clone()，可以使用拷贝构造函数或者拷贝工厂来拷贝一个对象。
     */
    @Data
    class A implements Serializable {
        private String name;

        public A(String name){
            this.name = name;
        }

        public A(A a){
            this.name = a.name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            A a = (A) o;
            return Objects.equals(name, a.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }

    public void dealData(String data){
        A a1 = new A("alen");
        A a2 = new A(a1);
        System.out.println(a1 == a2);
    }

    public static void main(String[] args) {
        PrototypeNote prototypeNote = new PrototypeNote();
        prototypeNote.dealData("alen");
    }

}


