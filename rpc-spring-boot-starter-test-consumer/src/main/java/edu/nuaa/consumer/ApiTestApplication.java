package edu.nuaa.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author brain
 * @version 1.0
 * @date 2023/6/21 20:51
 */
@SpringBootApplication
@ImportResource(locations = {"classpath:spring-config.xml"})
public class ApiTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiTestApplication.class, args);
    }
}

