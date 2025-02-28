package com.sonyadminportal.AdminApp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InputRequestModel {
    private Customer customer;
    private Product product;
}
