package com.sonyadminportal.AdminApp.service;

import com.sonyadminportal.AdminApp.cache.CacheUtil;
import com.sonyadminportal.AdminApp.config.BeanConfig;
import com.sonyadminportal.AdminApp.model.Customer;
import com.sonyadminportal.AdminApp.model.InputRequestModel;
import com.sonyadminportal.AdminApp.model.Product;
import com.sonyadminportal.AdminApp.model.ResponseModel;
import com.sonyadminportal.AdminApp.repository.CustomerRepository;
import com.sonyadminportal.AdminApp.repository.ProductRepository;
import com.sonyadminportal.AdminApp.exception.InvalidBrandException;
import com.sonyadminportal.AdminApp.validator.ValidityCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Transactional
@Service
public class AdminPortalServiceImpl implements AdminPortalService {
    @Autowired
    private ValidityCheck validityCheck;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CacheUtil cacheUtil;
    @Autowired
    private RestTemplate restTemplate;


    @Override
    public Customer saveCustomerInfo(Customer customer) {
       String randomValue= randomNumber();
       customer.setCustomerId(randomValue);
        Customer customerResponse=customerRepository.save(customer);
        return customerResponse;
    }

    @Override
    public Customer getCustomerById(int id) {
        Optional<Customer> customerResponse=customerRepository.findById(id);
        return customerResponse.get();
    }



    @Override
    public Customer getCustomerByCustomerId(String customerId) {
        Customer customerResponse=customerRepository.getCustomerByCustomerId(customerId);
        return customerResponse;
    }


    @Override
    public Object[] getCustNameAndAddressByEmailId(String emailId) {
        Object[] customerResponse=customerRepository.getCustNameAndAddressByEmailId(emailId);
        return customerResponse;
    }
    public Customer getCustomerByMobNum(String mobNumber) {
         Customer   customerResponse=customerRepository.getByMobileNumber(mobNumber);
        return customerResponse;
    }

    @Override
    public String getOrderId() {

        ResponseEntity<String> responseEntity=restTemplate.exchange("http://localhost:8082/tracking", HttpMethod.GET,null, String.class);
        return responseEntity.getBody();
    }

    @Override
    public Customer saveCustomerWithOrderId(Customer customer) {

        String value=randomNumber();
        customer.setCustomerId(value);
        HttpEntity entity=new HttpEntity(customer);
        //ResponseEntity<Customer> customerResponse=restTemplate.exchange("http://localhost:8082/save",HttpMethod.POST,entity, Customer.class);
        //ResponseEntity<Customer> customerResponse= restTemplate.postForEntity("http://localhost:8082/save",entity,Customer.class);
        Customer customerResponse=restTemplate.postForObject("http://localhost:8082/save",entity, Customer.class);
        return customerResponse;
    }

    @Override
    public Customer getCustomerByEmailId(String emailId) {
       Customer customerResponse= customerRepository.getCustomerByEmailId(emailId);
        return customerResponse;
    }

    @Override
    public Customer getProdAndAddByMobNum(String mobNumber) {
        Customer customerResponse=customerRepository.getProdAndAddByMobNum(mobNumber);
        return customerResponse;
    }

    @Override//@transactional annotation need to write on top of service class to undo the customer table if the brand was wrong
                //or it wiil be stored on the customer table
    public ResponseModel saveProductAndCustomerInfo(InputRequestModel inputRequestModel) {
        String customerRandomValue=randomNumber();
        Customer customer=inputRequestModel.getCustomer();
        customer.setCustomerId(customerRandomValue);
        Customer customerResponse=customerRepository.save(customer);
        String productRandomValue=randomNumber();
        Product product=inputRequestModel.getProduct();
        product.setProductCode(productRandomValue);
        Product productResponse=null;

        if(validityCheck.isValid(product.getProductBrand()))
        {
            productResponse=productRepository.save(product);
        }
        else {
            throw new InvalidBrandException("sorry not a valid product brand");
        }

        return ResponseModel.builder()
                .customerId(customerResponse.getCustomerId())
                .productCode(productResponse.getProductCode()).build();
//        ResponseModel responseModel=new ResponseModel();
//        responseModel.setCustomerId(customerResponse.getCustomerId());
//        responseModel.setProductCode(productResponse.getProductCode());



    }

    private String randomNumber() {
        Double randomNumber= Math.random();
        String value=randomNumber.toString().substring(2).substring(2,6);
        return  value;
    }
}
