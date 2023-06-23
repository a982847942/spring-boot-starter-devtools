package edu.nuaa.edu.nuaa.hystrix;

import edu.nuaa.edu.nuaa.hystrix.annotation.DoHystrix;
import edu.nuaa.edu.nuaa.hystrix.value.IValueService;
import edu.nuaa.edu.nuaa.hystrix.value.impl.HystrixValueImpl;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author brain
 * @version 1.0
 * @date 2023/6/20 16:15
 */
@Aspect
//@Component
public class DoHystrixPoint {
    @Pointcut("@annotation(edu.nuaa.edu.nuaa.hystrix.annotation.DoHystrix)")
    public void aopPoint() {
    }

    @Around("aopPoint() && @annotation(doGovern)")
    public Object doRouter(ProceedingJoinPoint jp, DoHystrix doGovern) throws Throwable {
        IValueService valveService = new HystrixValueImpl(doGovern.timeoutValue());
        return valveService.access(jp, getMethod(jp), doGovern, jp.getArgs());
    }

    private Method getMethod(JoinPoint jp) throws NoSuchMethodException {
        Signature sig = jp.getSignature();
        MethodSignature methodSignature = (MethodSignature) sig;
        return jp.getTarget().getClass().getMethod(methodSignature.getName(), methodSignature.getParameterTypes());
    }

}
