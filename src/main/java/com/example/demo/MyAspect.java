package com.example.demo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class MyAspect {
    //切入點HpPrinter裡的所有方法，在執行切入方法先執行before
    @Before("execution(* com.example.demo.HpPrinter.*(..))")
    public void before(){
        System.out.println("before");
    }

    @After("execution(* com.example.demo.HpPrinter.*(..))")
    public void after(){
        System.out.println("after");
    }

    @Around("execution(* com.example.demo.HpPrinter.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        Date start = new Date();
        System.out.println("around before");
        //執行切入點的方法
        Object proceed = joinPoint.proceed();

        System.out.println("around after");
        Date end = new Date();
        long diff = end.getTime() - start.getTime();
        System.out.println("總共執行了"+diff+"ms");
        return proceed;
    }
}
