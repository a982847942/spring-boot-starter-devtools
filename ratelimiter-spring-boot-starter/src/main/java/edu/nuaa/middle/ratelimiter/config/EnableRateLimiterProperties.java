package edu.nuaa.middle.ratelimiter.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author brain
 * @version 1.0
 * @date 2023/7/7 20:35
 */
@ConfigurationProperties("zk.ratelimiter")
public class EnableRateLimiterProperties {
    private boolean enable;

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
