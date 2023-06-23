package edu.nuaa.middle.ratelimiter.valve;

import edu.nuaa.middle.ratelimiter.annotation.DoRateLimiter;
import org.aspectj.lang.ProceedingJoinPoint;

import java.lang.reflect.Method;

/**
 * @author brain
 * @version 1.0
 * @date 2023/6/21 9:33
 */
public interface IValveService {
    Object access(ProceedingJoinPoint jp, Method method, DoRateLimiter doRateLimiter, Object[] args) throws Throwable;
}
