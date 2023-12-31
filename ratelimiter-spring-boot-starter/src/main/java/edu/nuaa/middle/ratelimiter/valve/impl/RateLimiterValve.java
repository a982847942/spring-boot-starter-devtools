package edu.nuaa.middle.ratelimiter.valve.impl;

import com.alibaba.fastjson.JSON;
import com.google.common.util.concurrent.RateLimiter;
import edu.nuaa.middle.ratelimiter.Constants;
import edu.nuaa.middle.ratelimiter.annotation.DoRateLimiter;
import edu.nuaa.middle.ratelimiter.valve.IValveService;
import org.aspectj.lang.ProceedingJoinPoint;

import java.lang.reflect.Method;

/**
 * @author brain
 * @version 1.0
 * @date 2023/6/21 9:33
 */
public class RateLimiterValve implements IValveService {
    @Override
    public Object access(ProceedingJoinPoint jp, Method method, DoRateLimiter doRateLimiter, Object[] args) throws Throwable {
        if(doRateLimiter.permitsPerSecond() == 0)return jp.proceed();
        String clazzName = jp.getTarget().getClass().getName();
        String methodName = method.getName();
        String key = clazzName + "." + methodName;
        if (null == Constants.rateLimiterMap.get(key)){
            Constants.rateLimiterMap.put(key,RateLimiter.create(doRateLimiter.permitsPerSecond()));
        }
        RateLimiter rateLimiter = Constants.rateLimiterMap.get(key);
        if (rateLimiter.tryAcquire()){
            return jp.proceed();
        }
        return JSON.parseObject(doRateLimiter.returnJson(),method.getReturnType());
    }
}
