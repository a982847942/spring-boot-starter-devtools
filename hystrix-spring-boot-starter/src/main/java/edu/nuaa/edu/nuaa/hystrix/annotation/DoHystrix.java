package edu.nuaa.edu.nuaa.hystrix.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author brain
 * @version 1.0
 * @date 2023/6/20 16:15
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DoHystrix {
    String returnJson() default "";//失败结果
    int timeoutValue() default 0;//超时熔断时间
}
