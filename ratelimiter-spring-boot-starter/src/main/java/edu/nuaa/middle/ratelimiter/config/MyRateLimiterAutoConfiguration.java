package edu.nuaa.middle.ratelimiter.config;

import edu.nuaa.middle.ratelimiter.DoRateLimiterPoint;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author brain
 * @version 1.0
 * @date 2023/7/7 20:30
 */
@Configuration
@EnableConfigurationProperties(EnableRateLimiterProperties.class)
@ConditionalOnProperty(prefix = "zk.ratelimiter",name = "enable",havingValue = "true")
public class MyRateLimiterAutoConfiguration {
    @Bean
    public DoRateLimiterPoint doRateLimiterPoint(){
        return new DoRateLimiterPoint();
    }
}
