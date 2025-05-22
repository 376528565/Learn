package com.JVM;

/**
 * @Author: LQL
 * @Date: 2024/07/22
 * @Description:
 */
public class ExceptionCode {

    public int foo() {
        int x;
        try {
            x = 1;
            return x;
        } catch (Exception e) {
            x = 2;
            return x;
        } finally {
            x = 3;
        }
    }

}
