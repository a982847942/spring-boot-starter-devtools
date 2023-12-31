package edu.nuaa.middle.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackages;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author brain
 * @version 1.0
 * @date 2023/6/21 9:55
 */
@SpringBootApplication
public class ApiTestApplication implements CommandLineRunner {
    @Autowired
    private BeanFactory beanFactory;
    public static void main(String[] args) {
        SpringApplication.run(ApiTestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("==================================");
        System.out.println("beanFactory:" + beanFactory.getClass().getName());
        System.out.println(AutoConfigurationPackages.get(beanFactory));
        System.out.println("==================================");
    }
}
