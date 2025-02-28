package com.sonyadminportal.AdminApp.repository;

import com.sonyadminportal.AdminApp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
