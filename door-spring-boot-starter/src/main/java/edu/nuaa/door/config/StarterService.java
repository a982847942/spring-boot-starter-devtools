package edu.nuaa.door.config;

import org.springframework.util.StringUtils;

/**
 * @author brain
 * @version 1.0
 * @date 2023/6/19 9:51
 */
public class StarterService {
    private String userStr;

    public StarterService(String userStr) {
        this.userStr = userStr;
    }

    public String[] split(String separatorChar) {
        return StringUtils.split(this.userStr, separatorChar);
    }
}
