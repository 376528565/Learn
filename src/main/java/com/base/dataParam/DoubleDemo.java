package com.base.dataParam;

import java.math.BigDecimal;

/**
 * @Author: LQL
 * @Date: 2025/02/11
 * @Description:
 */
public class DoubleDemo {

    public static void main(String[] args) {
        BigDecimal decimal = new BigDecimal(1.32);
        String a = "AB";
        String b = "A" + "B";
        System.out.println(a == b);
    }

}
