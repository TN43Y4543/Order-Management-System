package com.sonyadminportal.AdminApp.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Table(name = "Customer")
@Entity
@AllArgsConstructor
@NoArgsConstructor
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class Customer {
    @GeneratedValue(strategy = GenerationType.AUTO )
    @Id
    private int id;
    private String customerId;
    private String customerName;
    private String mobNumber;
    private String emailId;
    private String address;
    private String productName;
    private String orderTrackingId;
    Customer(String productName,String address)
    {
        this.productName=productName;
        this.address=address;
    }
}
