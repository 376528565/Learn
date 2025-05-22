package com.util;

import java.lang.annotation.*;

/**
 * @author liqia
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.TYPE)
public @interface Alen {
    String value() default "alen";
}
