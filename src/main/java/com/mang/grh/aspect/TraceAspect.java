package com.mang.grh.aspect;

import com.mang.grh.entities.Administration.Logging.OperationTrace;
import com.mang.grh.services.Adminstration.Logging.OperationTraceService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Aspect
@Component
public class TraceAspect {
    @Autowired
    private OperationTraceService service;

    private static final Logger logger = LoggerFactory.getLogger(TraceAspect.class);

    @AfterReturning(pointcut = "execution(* com.mang.grh.Repositories.*Repo.*(..))", returning = "result")
    public void logAfter(JoinPoint joinPoint, Object result) {

        logger.info("Intercepted method: " + joinPoint.getSignature().getName());
        logger.info("Entity: " + joinPoint.getTarget().getClass().getSimpleName());

        OperationTrace trace = new OperationTrace();
        trace.setOperation(joinPoint.getSignature().getName());
        trace.setEntityName(joinPoint.getTarget().getClass().getSimpleName());
        trace.setTimestamp(LocalDateTime.now().toString());
        service.saveTrace(trace);
    }
}
