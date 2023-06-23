package edu.nuaa.edu.nuaa.hystrix.value;

import edu.nuaa.edu.nuaa.hystrix.annotation.DoHystrix;
import org.aspectj.lang.ProceedingJoinPoint;

import java.lang.reflect.Method;

/**
 * @author brain
 * @version 1.0
 * @date 2023/6/20 16:16
 */
public interface IValueService {
    Object access(ProceedingJoinPoint jp, Method method, DoHystrix doHystrix, Object[] args) throws Throwable;
}
