package edu.nuaa.middleware.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author brain
 * @version 1.0
 * @date 2023/12/30 16:16
 */
@SpringBootApplication
@ComponentScan(basePackages = {"edu.nuaa.middleware"})
public class ApiTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiTestApplication.class, args);
    }

}
