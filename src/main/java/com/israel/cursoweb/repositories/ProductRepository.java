package com.israel.cursoweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.israel.cursoweb.entites.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	
		
}
