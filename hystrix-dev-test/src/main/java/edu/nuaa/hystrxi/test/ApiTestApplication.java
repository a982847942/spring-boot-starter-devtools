package edu.nuaa.hystrxi.test;

import edu.nuaa.edu.nuaa.hystrix.annotation.EnableHystrix;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @author brain
 * @version 1.0
 * @date 2023/6/20 16:30
 */
@SpringBootApplication
@EnableHystrix
//@ComponentScan({"edu.nuaa.hystrxi","edu.nuaa.edu.nuaa.hystrix"})
public class ApiTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiTestApplication.class, args);
    }

}
