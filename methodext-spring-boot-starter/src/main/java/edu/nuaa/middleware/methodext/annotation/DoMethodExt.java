package edu.nuaa.middleware.methodext.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author brain
 * @version 1.0
 * @date 2023/6/21 11:01
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DoMethodExt {
    String method() default "";
    String returnJson() default "";
}
