package com.base.annotation;

/**
 * @Author: LQL
 * @Date: 2025/03/31
 * @Description:
 */
@Alen("123")
public class AnnotationDemo {

    public static void main(String[] args) {
        Class<AnnotationDemo> annotationDemoClass = AnnotationDemo.class;
        Alen annotation = annotationDemoClass.getAnnotation(Alen.class);
        System.out.println(annotation.value());
    }

}
