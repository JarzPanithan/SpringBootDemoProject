package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Product2;

@Repository
public interface Product2Repository extends JpaRepository<Product2, Long> {
	public Product2 findByProductName(String productName);
}
