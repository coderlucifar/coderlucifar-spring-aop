package com.coderlucifar.aop.log.annotation;

import com.coderlucifar.aop.log.Convert;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RecordOperate {

    String desc() default "";

    Class<? extends Convert> convert();

}
