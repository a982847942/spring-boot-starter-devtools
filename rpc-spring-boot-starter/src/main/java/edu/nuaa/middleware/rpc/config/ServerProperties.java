package edu.nuaa.middleware.rpc.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author brain
 * @version 1.0
 * @date 2023/6/21 15:52
 */
@ConfigurationProperties("rpc.server")
public class ServerProperties {
    private String host;//注册中心地址
    private int port;//注册中心服务端口

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
