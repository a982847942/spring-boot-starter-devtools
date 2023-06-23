package edu.nuaa.hystrxi.test.interfaces;

import edu.nuaa.edu.nuaa.hystrix.DoHystrixPoint;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @author brain
 * @version 1.0
 * @date 2023/6/22 16:04
 */
@Component
public class MyTest implements ApplicationContextAware {
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        String[] beanNamesForType = applicationContext.getBeanNamesForType(DoHystrixPoint.class);
        System.out.println(beanNamesForType.length);
    }
}
