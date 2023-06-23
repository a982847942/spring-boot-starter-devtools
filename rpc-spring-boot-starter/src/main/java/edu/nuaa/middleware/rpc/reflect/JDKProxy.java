package edu.nuaa.middleware.rpc.reflect;

import edu.nuaa.middleware.rpc.network.msg.Request;
import edu.nuaa.middleware.rpc.util.ClassLoaderUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author brain
 * @version 1.0
 * @date 2023/6/21 15:56
 */
public class JDKProxy {
    public static <T> T getProxy(Class<T> interfaceClass, Request request) throws Exception {
        InvocationHandler handler = new JDKInvocationHandler(request);
        ClassLoader classLoader = ClassLoaderUtils.getCurrentClassLoader();
        T result = (T) Proxy.newProxyInstance(classLoader, new Class[]{interfaceClass}, handler);
        return result;
    }

}
