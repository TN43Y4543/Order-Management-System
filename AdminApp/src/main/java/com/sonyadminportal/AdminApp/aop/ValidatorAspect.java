package com.sonyadminportal.AdminApp.aop;

import com.sonyadminportal.AdminApp.validator.MobNumberValidator;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidatorAspect {
    @Autowired
    MobNumberValidator mobNumberValidator;
    //@Before("execution(* com.sonyadminportal.AdminApp.service.AdminPortalServiceImpl.getCustomerByMobNum(..))")
    public void validate(JoinPoint joinPoint)
    {
        String className=joinPoint.getClass().getName();
        String methodName=joinPoint.getSignature().getName();
        String mobileNumber= (String) joinPoint.getArgs()[0];

        System.out.println("Class Name :"+className);
        System.out.println("Method Name :"+methodName);
        System.out.println("mobile Number :"+mobileNumber);
        if(mobNumberValidator.validateMobNum(mobileNumber))
        {
            System.out.println("valid mobile number");
        }
        else
        {
            System.out.println("not a valid mobile number");
            throw new RuntimeException("not a valid mobileNumber");
        }
    }
}
