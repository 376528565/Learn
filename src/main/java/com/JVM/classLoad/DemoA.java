package com.JVM.classLoad;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: LQL
 * @Date: 2024/07/22
 * @Description:
 */
@Data
@AllArgsConstructor
public class DemoA {

    static {
        System.out.println("deal static data");
    }

    private String name;

}
