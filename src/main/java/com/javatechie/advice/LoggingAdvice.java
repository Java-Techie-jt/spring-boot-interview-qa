//package com.javatechie.advice;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.*;
//import org.springframework.stereotype.Component;
//
//@Aspect
//@Component
//@Slf4j
//public class LoggingAdvice {
//
//    @Pointcut("execution(* com.javatechie.service.ProductService.*(..))")
//    private void logPointcut() {
//    }
//
//    @Before("logPointcut()")
//    public void logRequest(JoinPoint joinPoint) throws JsonProcessingException {
//        log.info("Before Advice - class name {} ,method name {} ", joinPoint.getTarget(), joinPoint.getSignature().getName());
//        log.info("Before Advice - Request Body {} ", new ObjectMapper().writeValueAsString(joinPoint.getArgs()));
//    }
//
////    @AfterReturning(value = "execution (* com.javatechie.controller.ProductController.*(..))",returning = "object")
////    public void logResponse(JoinPoint joinPoint,Object object) throws JsonProcessingException {
////        log.info("LoggingAdvice::logResponse class name {} ,method name {} ", joinPoint.getTarget(), joinPoint.getSignature().getName());
////        log.info("LoggingAdvice::logResponse Response Body {} ", new ObjectMapper().writeValueAsString(object));
////    }
//
//    @After(value = "execution (* com.javatechie.service.ProductService.*(..))")
//    public void logResponse(JoinPoint joinPoint) throws JsonProcessingException {
//        log.info("After Advice - LoggingAdvice::logResponse class name {} ,method name {} ", joinPoint.getTarget(), joinPoint.getSignature().getName());
//        log.info("After Advice - LoggingAdvice::logResponse Response Body {} ", new ObjectMapper().writeValueAsString(joinPoint.getArgs()));
//    }
//
//
//    @AfterThrowing(value = "execution (* com.javatechie.service.ProductService.*(..))")
//    public void logError(JoinPoint joinPoint) throws JsonProcessingException {
//        log.info("Throws Advice - LoggingAdvice::logResponse class name {} ,method name {} ", joinPoint.getTarget(), joinPoint.getSignature().getName());
//        log.info("Throws Advice - LoggingAdvice::logResponse Response Body {} ", new ObjectMapper().writeValueAsString(joinPoint.getArgs()));
//    }
//
//
//}