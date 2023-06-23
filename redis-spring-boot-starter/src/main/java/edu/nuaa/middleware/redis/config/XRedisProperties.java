package edu.nuaa.middleware.redis.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author brain
 * @version 1.0
 * @date 2023/6/23 13:08
 */
@ConfigurationProperties("redis")
public class XRedisProperties {
    private String host;
    private int port;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
