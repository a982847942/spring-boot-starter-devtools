package edu.nuaa.middle.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author brain
 * @version 1.0
 * @date 2023/6/21 9:55
 */
@SpringBootApplication
//@ComponentScan({"edu.nuaa.middle.test","edu.nuaa.middle.ratelimiter"})
public class ApiTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiTestApplication.class, args);
    }
}
