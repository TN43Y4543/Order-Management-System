package com.sonyadminportal.AdminApp.controller;

import com.sonyadminportal.AdminApp.model.Customer;
import com.sonyadminportal.AdminApp.model.InputRequestModel;
import com.sonyadminportal.AdminApp.model.Product;
import com.sonyadminportal.AdminApp.model.ResponseModel;
import com.sonyadminportal.AdminApp.service.AdminPortalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class AdminPortalController {
    @Autowired
    private AdminPortalService adminPortalService;
    @PostMapping("/save")
    public ResponseEntity<Customer> saveCustomerInfo(@RequestBody Customer customer)
    {
        Customer customerResponse=adminPortalService.saveCustomerInfo(customer);
        return new ResponseEntity<>(customerResponse, HttpStatus.OK);
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") int id)
    {
        Customer customerResponse=adminPortalService.getCustomerById(id);
        return new ResponseEntity<>(customerResponse,HttpStatus.OK);
    }
    @GetMapping("/customerid/{customerid}")
    public ResponseEntity<Customer> getCustomerByCustomerId(@PathVariable("customerid") String CustomerId)
    {
        Customer customerResponse=adminPortalService.getCustomerByCustomerId(CustomerId);
        return new ResponseEntity<>(customerResponse,HttpStatus.OK);
    }
    @GetMapping("/mobileNumber/{mobileNumber}")
    public ResponseEntity<Customer> getCustomerByMobNum (@PathVariable("mobileNumber") String mobNumber)
    {
        Customer customerResponse= adminPortalService.getCustomerByMobNum(mobNumber);
        return new ResponseEntity<>(customerResponse,HttpStatus.OK);

    }
    @GetMapping("/product/address/{emailid}")
    public ResponseEntity<?> getCustNameAndAddressByEmailId(@PathVariable("emailid") String emailId)
    {
        Object[] customerResponse=adminPortalService.getCustNameAndAddressByEmailId(emailId);
        return new ResponseEntity<>(customerResponse,HttpStatus.OK);
    }
    @GetMapping("/emailid/{emailid}")
    public ResponseEntity<Customer> getCustomerByEmailId(@PathVariable("emailid") String emailId)
    {
        Customer customerResponse=adminPortalService.getCustomerByEmailId(emailId);
        return new ResponseEntity<>(customerResponse,HttpStatus.OK);
    }
    @GetMapping("/product/address/{mobileNumber}")
    public ResponseEntity<Customer> getProdAndAddByMobNum(@PathVariable("mobileNumber") String mobNumber)
    {
        Customer customerResponse=adminPortalService.getProdAndAddByMobNum(mobNumber);
        return new ResponseEntity<>(customerResponse,HttpStatus.OK);
    }
    @PostMapping("/save/product/customer")
    public ResponseEntity<ResponseModel> saveProductAndCustomerInfo(@RequestBody InputRequestModel inputRequestModel)
    {
        ResponseModel responseModel=adminPortalService.saveProductAndCustomerInfo(inputRequestModel);
         return new ResponseEntity(responseModel,HttpStatus.OK);
    }

    @GetMapping("/orderId/tracking")
    public ResponseEntity<String> getOrderIdForTracking()
    {
        String orderId=adminPortalService.getOrderId();
        return new ResponseEntity<>(orderId,HttpStatus.OK);
    }

    @PostMapping("save/orderId")
    public ResponseEntity<Customer> saveCustomerWithOrderId(@RequestBody Customer customer)
    {
        Customer customerResponse=adminPortalService.saveCustomerWithOrderId(customer);
        return new ResponseEntity<>(customerResponse,HttpStatus.OK);
    }


    @GetMapping("/test")
    public InputRequestModel test()
    {
        Customer customer=Customer.builder().customerName("sudesh").build();
        Product product=Product.builder().productName("mouse").build();
        InputRequestModel inputRequestModel=new InputRequestModel(customer,product);
        return inputRequestModel;
    }

    @GetMapping("/hii")
    public ResponseEntity<String> Hii()
    {
        return new ResponseEntity<>("Hello all",HttpStatus.OK);
    }


}
