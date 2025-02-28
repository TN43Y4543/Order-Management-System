package com.sonyadminportal.AdminApp.validator;

import org.springframework.stereotype.Component;

@Component
public class MobNumberValidator {
    public Boolean validateMobNum(String mobNumber)
    {
       return mobNumber.length()<=10;
    }

}
