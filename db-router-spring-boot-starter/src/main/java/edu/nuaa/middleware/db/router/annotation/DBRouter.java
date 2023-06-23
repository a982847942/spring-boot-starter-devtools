package edu.nuaa.middleware.db.router.annotation;

import java.lang.annotation.*;

/**
 * @author brain
 * @version 1.0
 * @date 2023/6/22 18:44
 */
@Documented
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface DBRouter {
    String key() default "";//用于路由的字段
}
