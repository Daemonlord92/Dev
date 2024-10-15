package com.blitmatthew.monster_trainer.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspects {
    @Around("@annotation(com.blitmatthew.monster_trainer.annotations.LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        log.info("{}.{} STARTED", joinPoint.getSignature().getDeclaringType(), joinPoint.getSignature().getName());
        Object proceed = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        long executionTime = startTime - endTime;
        log.info("{} executed in {} ms", joinPoint.getSignature(), executionTime);
        return proceed;
    }
}
