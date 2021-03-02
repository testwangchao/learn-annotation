package com.example.annotations.example.anns;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)  // 只作用于字段
@Retention(RetentionPolicy.RUNTIME)
public @interface Constraints {
    //判断是否作为主键约束
    boolean primaryKey() default false;

    //判断是否允许为null
    boolean allowNull() default false;

    //判断是否唯一
    boolean unique() default false;
}
