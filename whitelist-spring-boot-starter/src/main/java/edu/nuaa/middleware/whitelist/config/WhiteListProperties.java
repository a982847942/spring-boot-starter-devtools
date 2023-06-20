package edu.nuaa.middleware.whitelist.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author brain
 * @version 1.0
 * @date 2023/6/20 15:15
 */
@ConfigurationProperties("zk.whitelist")
public class WhiteListProperties {
    private String users;

    public String getUsers() {
        return users;
    }

    public void setUsers(String users) {
        this.users = users;
    }
}
