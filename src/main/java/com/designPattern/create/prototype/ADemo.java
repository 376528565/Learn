package com.designPattern.create.prototype;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: LQL
 * @Date: 2024/09/29
 * @Description:
 */
@Data
@AllArgsConstructor
public class ADemo {

    private String name;

    public ADemo(ADemo a){
        this.name = a.name;
    }

}
