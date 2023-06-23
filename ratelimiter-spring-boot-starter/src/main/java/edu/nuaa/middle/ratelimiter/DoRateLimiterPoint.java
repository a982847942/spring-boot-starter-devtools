package edu.nuaa.middle.ratelimiter;

import edu.nuaa.middle.ratelimiter.annotation.DoRateLimiter;
import edu.nuaa.middle.ratelimiter.valve.IValveService;
import edu.nuaa.middle.ratelimiter.valve.impl.RateLimiterValve;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

/**
 * @author brain
 * @version 1.0
 * @date 2023/6/21 9:36
 */

@Aspect
//@Component
public class DoRateLimiterPoint {
    @Pointcut("@annotation(edu.nuaa.middle.ratelimiter.annotation.DoRateLimiter)")
    public void aopPoint() {
    }

    @Around("aopPoint() && @annotation(doRateLimiter)")
    public Object doRouter(ProceedingJoinPoint jp, DoRateLimiter doRateLimiter) throws Throwable {
        IValveService valveService = new RateLimiterValve();
        return valveService.access(jp, getMethod(jp), doRateLimiter, jp.getArgs());
    }

    private Method getMethod(JoinPoint jp) throws NoSuchMethodException {
        Signature sig = jp.getSignature();
        MethodSignature methodSignature = (MethodSignature) sig;
        return jp.getTarget().getClass().getMethod(methodSignature.getName(), methodSignature.getParameterTypes());
    }

}
