package com.sonyadminportal.AdminApp.repository;

import com.sonyadminportal.AdminApp.model.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer,Integer> {

    Customer getCustomerByCustomerId(String customerId);
    @Query(value = "select customer_name,address from Customer where emailId=: emailId",nativeQuery = true)
    Object[] getCustNameAndAddressByEmailId(@Param("emailId") String emailId);
    @Query(value = "select customer from Customer customer where customer.emailId= :emailid")
    Customer getCustomerByEmailId(@Param("emailid") String emailId);
    @Query(value = "select new Customer(productName,address) from Customer a where a.mobNumber= :mobileNumber")
    Customer getProdAndAddByMobNum(@Param("mobileNumber") String mobNumber);

    @Query(value = "select*from customer where mob_number= :mobileNumber",nativeQuery = true)
    Customer getByMobileNumber(@Param("mobileNumber")String mobNumber);
}
