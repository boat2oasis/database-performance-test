package com.service.mall.annotate;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
//@Target({ElementType.PARAMETER, ElementType.METHOD})
//@Retention(RetentionPolicy.RUNTIME)
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.PARAMETER,ElementType.METHOD})
@Documented
public @interface Log {
	String title() default "";
}
