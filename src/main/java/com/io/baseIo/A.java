package com.io.baseIo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: LQL
 * @Date: 2024/07/31
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class A implements Serializable {

    private String name;
    private int age;
    private static int flag = 1;

}
