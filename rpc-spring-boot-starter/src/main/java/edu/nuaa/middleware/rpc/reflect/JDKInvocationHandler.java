package edu.nuaa.middleware.rpc.reflect;

import edu.nuaa.middleware.rpc.network.future.SyncWrite;
import edu.nuaa.middleware.rpc.network.msg.Request;
import edu.nuaa.middleware.rpc.network.msg.Response;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author brain
 * @version 1.0
 * @date 2023/6/21 15:56
 */
public class JDKInvocationHandler implements InvocationHandler {
    private Request request;

    public JDKInvocationHandler(Request request) {
        this.request = request;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        Class[] paramTypes = method.getParameterTypes();
        if ("toString".equals(methodName) && paramTypes.length == 0) {
            return request.toString();
        } else if ("hashCode".equals(methodName) && paramTypes.length == 0) {
            return request.hashCode();
        } else if ("equals".equals(methodName) && paramTypes.length == 1) {
            return request.equals(args[0]);
        }
        //设置参数
        request.setMethodName(methodName);
        request.setParamTypes(paramTypes);
        request.setArgs(args);
        request.setRef(request.getRef());
        Response response = new SyncWrite().writeAndSync(request.getChannel(), request, 5000);
        //异步调用
        return response.getResult();

    }

}
