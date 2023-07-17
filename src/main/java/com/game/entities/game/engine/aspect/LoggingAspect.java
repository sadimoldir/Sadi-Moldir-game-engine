package com.game.entities.game.engine.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggingAspect {
    @Before("execution(* com.game.entities.game.engine.dao.*.*(..))")
    public void beforeDatabaseOperation(JoinPoint joinPoint) {
        log.info("Before executing method:{}", joinPoint.getSignature().getName());
    }
    @AfterReturning("execution(* com.game.entities.game.engine.dao.*.*(..))")
    public void afterDatabaseOperation(JoinPoint joinPoint) {
        log.info("After executing method:{}", joinPoint.getSignature().getName());
    }

    @AfterThrowing(value = "execution(* com.game.entities.game.engine.dao.*.*(..))", throwing = "exception")
    public void afterThrowingDatabaseOperation(Throwable exception) {
        log.error("Error occurred: {}", exception.getMessage());
        throw new RuntimeException(exception);

    }
}

