package edu.nuaa.middleware.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @author brain
 * @version 1.0
 * @date 2023/6/21 11:07
 */
@SpringBootApplication
@ComponentScan({"edu.nuaa.middleware.test","edu.nuaa.middleware.methodext"})
public class ApiTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiTestApplication.class, args);
    }
}
