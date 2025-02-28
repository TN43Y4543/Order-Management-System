package com.sonyadminportal.AdminApp.validator;


import org.springframework.stereotype.Component;

@Component
public class ValidityCheck {

    public Boolean isValid(String productBrand) {
        return "sony".equalsIgnoreCase(productBrand);

    }
}
