package edu.nuaa.middleware.rpc.config.spring;

import edu.nuaa.middleware.rpc.config.spring.bean.ConsumerBean;
import edu.nuaa.middleware.rpc.config.spring.bean.ProviderBean;
import edu.nuaa.middleware.rpc.config.spring.bean.ServerBean;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @author brain
 * @version 1.0
 * @date 2023/6/21 15:51
 */
public class MyNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("server", new MyBeanDefinitionParser(ServerBean.class));
        registerBeanDefinitionParser("provider", new MyBeanDefinitionParser(ProviderBean.class));
        registerBeanDefinitionParser("consumer", new MyBeanDefinitionParser(ConsumerBean.class));
    }

}
