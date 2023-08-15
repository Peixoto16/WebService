package com.israel.cursoweb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.israel.cursoweb.entites.User;
import com.israel.cursoweb.repositories.UserRepository;
import com.israel.cursoweb.services.exceptions.DatabaseException;
import com.israel.cursoweb.services.exceptions.ResourceNotFoundExceptions;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
		
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundExceptions(id));
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void deleted(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundExceptions(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public User update(Long id, User obj) {
		try {
			User entity = repository.getReferenceById(id);
			update(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e){
			throw new ResourceNotFoundExceptions(id);
		}
		
	}

	private void update(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		
	}
	
}

