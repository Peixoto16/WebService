package com.israel.cursoweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.israel.cursoweb.entites.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

		
}
