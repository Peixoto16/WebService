package com.israel.cursoweb.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.israel.cursoweb.services.exceptions.DatabaseException;
import com.israel.cursoweb.services.exceptions.ResourceNotFoundExceptions;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundExceptions.class)
	public ResponseEntity<StandandError> resourceNotFound(ResourceNotFoundExceptions e, HttpServletRequest request) {
		String error = "Resource not found Querido";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandandError err = new StandandError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StandandError> database(DatabaseException e, HttpServletRequest request) {
		String error = "Erro no data base";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandandError err = new StandandError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	
	
}
