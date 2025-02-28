package com.sonyadminportal.AdminApp.aop;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ResponseAspect {

    //@After("execution(* com.sonyadminportal.AdminApp.service.AdminPortalServiceImpl.getCustomerByMobNum(..))")
    public void responseMessage()
    {
        System.out.println("customer info retrieved successfully");
    }

}
