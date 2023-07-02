package com.israel.cursoweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.israel.cursoweb.entites.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

	
		
}
