package tn.esprit.springproject.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class acpects {


    @Before("execution(* tn.esprit.springproject.services.*.*(..))")
    public void logMethodEntry1(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        log.info("In method"+name + ": ");
    }
    @After("execution(* tn.esprit.springproject.services.*.*(..))")
    public void logMethodEntry(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        log.info("In method"+name + ": ");
    }
    @Around("execution(* tn.esprit.springproject.services.*.*(..))")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object obj = pjp.proceed();
        long elapsedTime = System.currentTimeMillis() - start;
        log.info("methode execution time :" + elapsedTime + "millisecondes.");
        return obj;
    }


}
