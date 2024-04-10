package com.example.t1_hw1.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
@Slf4j
public class ExceptionHandlerAspect {
    @AfterThrowing(pointcut = "within(com.example.t1_hw1.service.*)", throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint, Exception exception) {
        log.info("Произошла ошибка при вызове метода: {}", joinPoint.getSignature().toShortString());
        log.info("Ошибку: {}", exception.getMessage());
    }
}
