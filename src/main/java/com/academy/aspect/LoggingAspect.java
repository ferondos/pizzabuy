package com.academy.aspect;

import com.academy.utils.MethodCallCounter;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.HashMap;
import java.util.Map;

@Component
@Aspect
public class LoggingAspect {

    private Logger log = LoggerFactory.getLogger(this.getClass());


    @Pointcut("execution(* com.academy.service.*.*(..))")
    public void serviceMethodsMillis() {
    }

    @Pointcut("execution(* com.academy.service.*.*(..))")
    public void serviceMethodsCalls() {
    }

    @Around("serviceMethodsMillis()")
    public Object timeInMillis(ProceedingJoinPoint point) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start(point.getSignature().getName());
        Object result = point.proceed();
        stopWatch.stop();
        System.out.println("Method "
                + point.getSignature().getName()
                + " working time: "
                + stopWatch.getLastTaskTimeMillis()
                + " ms\n");
        return result;
    }

    @Before("serviceMethodsCalls()")
    public void callsCount(JoinPoint point) {
        Map<String, Integer> map = MethodCallCounter.methodCalls;
        String methodName = point.getSignature().getDeclaringTypeName() + "." + point.getSignature().getName();
        Integer nodeValue = map.get(methodName);
        if (!map.containsKey(methodName)) {
            map.put(methodName, 1);
        } else {
            map.replace(methodName, ++nodeValue);
        }
        for (Map.Entry<String, Integer> node : map.entrySet()) {
            System.out.println("Method " + node.getKey() + " executed " + node.getValue() + " times");
        }
    }

}
