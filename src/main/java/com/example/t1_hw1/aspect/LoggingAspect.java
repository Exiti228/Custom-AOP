package com.example.t1_hw1.aspect;

import com.example.t1_hw1.model.LogData;
import com.example.t1_hw1.service.LogDataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
@Aspect
@Slf4j
@RequiredArgsConstructor
public class LoggingAspect {
    private final LogDataService logDataService;

    @Around("@annotation(com.example.t1_hw1.annotation.TrackTime)")
    public Object logTrackTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        long executionTime = System.currentTimeMillis() - start;

        log.info(joinPoint.getSignature() + " выполнен за " + executionTime + "мс");
        return proceed;
    }

    @Around("@annotation(com.example.t1_hw1.annotation.TrackAsyncTime)")
    public Object logTrackAsyncTime(ProceedingJoinPoint joinPoint) {
        return CompletableFuture.runAsync(() -> {
            try {
                long start = System.currentTimeMillis();
                Object proceed = joinPoint.proceed();
                long executionTime = System.currentTimeMillis() - start;
                log.info(joinPoint.getSignature().getName() + " асинхронно выполнен за " + executionTime + "мс ");
                LogData logData = new LogData();
                logData.setDurationMs((int)executionTime);
                logData.setMethodName(joinPoint.getSignature().getName());
                logDataService.save(logData);
            } catch (Throwable e) {
                e.printStackTrace();
            }
        });
    }
}
