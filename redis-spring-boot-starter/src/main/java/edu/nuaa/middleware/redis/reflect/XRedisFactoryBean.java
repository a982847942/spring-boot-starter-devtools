package edu.nuaa.middleware.redis.reflect;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author brain
 * @version 1.0
 * @date 2023/6/23 13:09
 */
public class XRedisFactoryBean<T> implements FactoryBean<T> {

    private Class<T> mapperInterface;
//    @Autowired
    @Resource
    private Jedis jedis;

    public XRedisFactoryBean(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    @Override
    public T getObject() throws Exception {
        InvocationHandler handler = (proxy, method, args) -> {
            String name = method.getName();
            if ("get".equals(name)) {
                return jedis.srandmember(args[0].toString());
            }
            if ("set".equals(name)) {
                return jedis.sadd(args[0].toString(), args[1].toString());
            }
            return "你被代理了，执行Redis操作！";
        };
        return (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{mapperInterface}, handler);
    }

    @Override
    public Class<?> getObjectType() {
        return mapperInterface;
    }
}

