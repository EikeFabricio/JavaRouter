package com.github.eikefabricio.event.annotation;

import com.github.eikefabricio.event.annotation.type.HttpMethod;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Router {

    String route() default "/";
    HttpMethod method() default HttpMethod.GET;

}
