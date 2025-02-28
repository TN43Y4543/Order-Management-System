package com.sonyadminportal.AdminApp.service;

import com.sonyadminportal.AdminApp.model.Customer;
import com.sonyadminportal.AdminApp.model.InputRequestModel;
import com.sonyadminportal.AdminApp.model.ResponseModel;

public interface AdminPortalService {
    public Customer saveCustomerInfo(Customer customer);
    Customer getProdAndAddByMobNum(String mobNumber);
    ResponseModel saveProductAndCustomerInfo(InputRequestModel inputRequestModel);

    Customer getCustomerByEmailId(String emailId);

    Customer getCustomerByCustomerId(String customerId);

    Customer getCustomerById(int id);

    Object[] getCustNameAndAddressByEmailId(String emailId);

    Customer getCustomerByMobNum(String mobNumber);

    String getOrderId();

    Customer saveCustomerWithOrderId(Customer customer);
}
