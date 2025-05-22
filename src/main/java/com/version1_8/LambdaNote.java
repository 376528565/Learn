package com.version1_8;

import com.sun.org.apache.xerces.internal.xs.StringList;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.expression.spel.ast.StringLiteral;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: LQL
 * @Date: 2024/07/22
 * @Description:
 */
public class LambdaNote {

    /**
     * java1.8新特性，lambda表达式
     */

    public static void main(String[] args) {
        List<A> stringList = new ArrayList<>();
        stringList.add(new A("1", 1));
        stringList.add(new A("2", 2));
        stringList.add(new A("1", 2));
        stringList.stream().
                collect(Collectors.toMap(
                        A::getName,
                        a -> a,
                        (a1,a2) -> a1.getAge() > a2.getAge()?a1:a2
                )).values()
                .forEach(System.out::println);
    }

    @Data
    @AllArgsConstructor
    static final class A {
        private String name;
        private int age;
    }

}
