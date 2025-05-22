package com.designPattern.create.prototype;

import com.designPattern.create.prototype.demo1.ProtoType;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: LQL
 * @Date: 2024/09/29
 * @Description:
 */
public class Demo1 {


    public static void main(String[] args) {
        ProtoType protoType = new ProtoType("alen", 12);
        ProtoType protoType1 = new ProtoType(protoType);
        System.out.println(protoType1 == protoType);
        System.out.println(protoType.getName() == protoType1.getName());
    }

}
