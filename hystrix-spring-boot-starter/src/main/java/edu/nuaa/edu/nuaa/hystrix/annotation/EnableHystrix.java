package edu.nuaa.edu.nuaa.hystrix.annotation;

import edu.nuaa.edu.nuaa.hystrix.DoHystrixPoint;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author brain
 * @version 1.0
 * @date 2023/6/22 15:47
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
//@ComponentScan("edu.nuaa.edu.nuaa.hystrix.*")
@Import({DoHystrixPoint.class})
public @interface EnableHystrix {
}
