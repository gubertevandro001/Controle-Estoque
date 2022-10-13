package br.edu.unidep.project.controllers.exceptions;
import java.util.NoSuchElementException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.edu.unidep.project.services.exceptions.ConstraintViolationException;
import br.edu.unidep.project.services.exceptions.DataIntegratyViolationException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<StandardError> dataIntegratyViolationException(DataIntegrityViolationException div) {
		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.CONFLICT.value(), "Ihuuul, Pau!");
		return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<StandardError> noSuchElement(NoSuchElementException div) {
		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.CONFLICT.value(), div.getMessage());
		return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<StandardError> constraintViolation(ConstraintViolationException div) {
		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.CONFLICT.value(), "Chave Mãe Localizada");
		return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
	}
}
