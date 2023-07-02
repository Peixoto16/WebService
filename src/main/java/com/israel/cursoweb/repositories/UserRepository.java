package com.israel.cursoweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.israel.cursoweb.entites.User;

public interface UserRepository extends JpaRepository<User, Long>{

	
		
}
