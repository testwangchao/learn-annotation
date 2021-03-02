package com.example.annotations;

import java.lang.annotation.*;

/**
 * ElementType.TYPE：标明该注解可以用于类、接口（包括注解类型）或enum声明
 */
@Inherited    // 可以让注解被继承，但这并不是真的继承，只是通过使用@Inherited，可以让子类Class对象使用getAnnotations()获取父类被@Inherited修饰的注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface AnnotationType1 {
    String name() default "";
}
