package edu.nuaa.door.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author brain
 * @version 1.0
 * @date 2023/6/19 9:51
 */

/**
 * @ConfigurationProperties
 * 从配置文件中绑定属性到对应的bean上，而@EnableConfigurationProperties负责导入这个已经绑定了属性的bean到spring容器中。
 * 简单来说@EnableConfigurationProperties就是相当于一个Component的功能，创建一个StarterServiceProperties的bean对象到IOC容器
 * 那么所有其他的和这个类相关的属性都可以在全局配置文件中定义，
 * 也就是说，真正“限制”我们可以在全局配置文件中配置哪些属性的类就是这些XxxxProperties类，
 * 它与配置文件中定义的prefix关键字开头的一组属性是唯一对应的。
 */
@ConfigurationProperties("edu.nuaa.door")
public class StarterServiceProperties {
    private String userStr;

    public String getUserStr() {
        return userStr;
    }

    public void setUserStr(String userStr) {
        this.userStr = userStr;
    }
}
