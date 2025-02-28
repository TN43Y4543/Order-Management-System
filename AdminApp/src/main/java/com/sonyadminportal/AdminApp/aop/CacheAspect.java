package com.sonyadminportal.AdminApp.aop;

import com.sonyadminportal.AdminApp.cache.CacheUtil;
import com.sonyadminportal.AdminApp.model.Customer;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class CacheAspect {
    @Autowired
    private CacheUtil cacheUtil;
    @Around("execution(* com.sonyadminportal.AdminApp.service.AdminPortalServiceImpl.getCustomerByMobNum(..))")
    public Customer execute(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Customer customer=null;
       String className= proceedingJoinPoint.getTarget().getClass().getName();
       String methodName= proceedingJoinPoint.getSignature().getName();
       String mobNumber= (String) proceedingJoinPoint.getArgs()[0];
        System.out.println("Class Name :"+className);
        System.out.println("Method Name :"+methodName);
        System.out.println("mobile Number :"+mobNumber);
        if(cacheUtil.isKeyPresent(mobNumber))
        {
            customer=cacheUtil.getValue(mobNumber);
            System.out.println("Customer retrieved from local cache");
        }
        else {
            customer= (Customer) proceedingJoinPoint.proceed();
            cacheUtil.insertIntoCache(mobNumber,customer);
            System.out.println("Customer retrieved from database");
        }
        return customer;
    }
}
