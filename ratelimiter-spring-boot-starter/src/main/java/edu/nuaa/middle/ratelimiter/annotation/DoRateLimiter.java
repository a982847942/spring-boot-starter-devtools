package edu.nuaa.middle.ratelimiter.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author brain
 * @version 1.0
 * @date 2023/6/21 9:32
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DoRateLimiter {
    double permitsPerSecond() default 0D;
    String returnJson() default "";
}
