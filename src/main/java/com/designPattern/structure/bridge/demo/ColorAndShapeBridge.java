package com.designPattern.structure.bridge.demo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @Author: LQL
 * @Date: 2025/03/31
 * @Description:
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ColorAndShapeBridge {

    private Color color;
    private Shape shape;

    public void info(){
        color.show();
        shape.shape();
    }

}
