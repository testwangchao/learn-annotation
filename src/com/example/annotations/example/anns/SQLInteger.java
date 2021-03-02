package com.example.annotations.example.anns;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解Integer类型的字段
 */
@Target(ElementType.FIELD)  // 只作用于字段
@Retention(RetentionPolicy.RUNTIME)
public @interface SQLInteger {
    // 对应数据库表的列名
    String name() default "";

    Constraints constraint() default @Constraints;

}
