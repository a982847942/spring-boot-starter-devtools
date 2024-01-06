package edu.nuaa.middleware.db.router.annotation;

import java.lang.annotation.*;

/**
 * @author brain
 * @version 1.0
 * @date 2023/12/31 12:18
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface DBRouterStrategy {
    boolean splitTable() default false;
}
