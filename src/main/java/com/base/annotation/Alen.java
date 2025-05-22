package com.base.annotation;

import java.lang.annotation.*;

/**
 * 运行时注解、作用在方法、类上，记录doc文档
 */
@Documented
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Alen {

    String value() default "1";

}
