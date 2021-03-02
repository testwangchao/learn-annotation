package com.example.annotations;

import java.lang.annotation.Annotation;
import java.util.Arrays;

@AnnotationType1(name = "adsdas")
class Demo1 {}


@AnnotationType2
public class Annotaion1Impl extends Demo1{
    /**
     * 注解和反射的部分API
     * @param args
     */
    public static void main(String[] args) {
        Class<?> clazz = Annotaion1Impl.class;
        //根据指定注解类型获取该注解
        AnnotationType1 annotationType1=clazz.getAnnotation(AnnotationType1.class);
        System.out.println(annotationType1);  // @com.example.annotations.AnnotationType1(name=adsdas)

        // 获取该元素上的所有注解，包含从父类继承
        Annotation[] ans= clazz.getAnnotations();
        System.out.println(Arrays.toString(ans));  // [@com.example.annotations.AnnotationType1(name=adsdas), @com.example.annotations.AnnotationType2(is_test=false)]

        //获取该元素上的所有注解，但不包含继承！
        Annotation[] ans2 = clazz.getDeclaredAnnotations();
        System.out.println(Arrays.toString(ans2)); //  [@com.example.annotations.AnnotationType2(is_test=false)]

        // 判断注解是否在对象上
        boolean is_in_ann1 = clazz.isAnnotationPresent(AnnotationType1.class);
        boolean is_in_ann2 = clazz.isAnnotationPresent(AnnotationType2.class);
        System.out.println(is_in_ann1); // true
        System.out.println(is_in_ann2); // true
    }
}

