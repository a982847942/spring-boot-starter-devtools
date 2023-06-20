package edu.nuaa.middleware.whitelist.annotation;

import java.lang.annotation.*;

/**
 * @author brain
 * @version 1.0
 * @date 2023/6/20 15:14
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface DoWhiteList {
    String key() default "";
    String returnJson() default "";
}
