package com.israel.cursoweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.israel.cursoweb.entites.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
	
	
		
}
