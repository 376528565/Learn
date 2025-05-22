package com.designPattern.create.prototype.demo1;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: LQL
 * @Date: 2025/03/31
 * @Description:
 */
@AllArgsConstructor
@Getter
public class ProtoType implements Cloneable{
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


    private String name;
    private int age;

    /**
     * 构造函数实现克隆类
     * @param protoType
     */
    public ProtoType(ProtoType protoType){
        this.name = protoType.name;
        this.age = protoType.age;
    }

}
