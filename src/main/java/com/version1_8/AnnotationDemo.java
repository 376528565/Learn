package com.version1_8;

import com.util.Alen;

/**
 * @Author: LQL
 * @Date: 2024/07/22
 * @Description:
 */
@Alen()
public class AnnotationDemo {

    public static void main(String[] args) {
        AnnotationDemo annotationDemo = new AnnotationDemo();
        Class<? extends AnnotationDemo> annotationDemoClass = annotationDemo.getClass();
        Alen annotation = annotationDemoClass.getAnnotation(Alen.class);
        System.out.println(annotation.value());
    }


}
