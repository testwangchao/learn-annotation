package com.example.annotations.example.anns;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 表注解
 */
@Target(ElementType.TYPE)  // 只作用于类
@Retention(RetentionPolicy.RUNTIME)
public @interface DBTable {
    String name() default "";
}
