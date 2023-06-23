package edu.nuaa.middleware.rpc.annotaion;

import edu.nuaa.middleware.rpc.config.ServerAutoConfiguration;
import edu.nuaa.middleware.rpc.config.ServerProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author brain
 * @version 1.0
 * @date 2023/6/21 15:50
 */

/**
 * 测试一下是不是只要注解上加了Component在SpringbootApplication启动时都可以扫描到进行处理
 *   不是，但是可以扫描第三方jar包中的@Import注解
 * spring.handlers用法
 * dubbo看一下
 * yml和xml实现的区别
 *      provider使用yml方式（用EnableRpc来触发相关操作），在rpc配置文件中没有server标签不会触发MyBeanDefinitionParser(ServerBean.class)
 *      consumer使用xml，有server标签会触发，没有EnableRpc不会触发解析yml文件操作
 * 如何用注解实现方法注册和发现
 *      自己实现注册处理类（使用AOP），注解包括方法，别名等信息，解析之后得到跟XML配置类似的信息
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
//这两个注解是配合使用yml方式注册
@Import({ServerAutoConfiguration.class})
@EnableConfigurationProperties(ServerProperties.class)
//@ComponentScan("edu.nuaa.middleware.*")
public @interface EnableRpc {
}
