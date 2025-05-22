package com.base.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: LQL
 * @Date: 2024/07/15
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SerializableDemo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    transient private String address;

    /**
     * 序列化和反序列化可以确保实现serializable的类在项目、网络中传输，在文件中存储
     * 通过二进制字节流的形式在不同项目之间传递对象以及它的数据
     */

}
