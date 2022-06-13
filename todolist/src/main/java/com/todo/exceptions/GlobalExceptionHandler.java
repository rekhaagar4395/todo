package com.todo.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.todo.dto.ErrorDto;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(TodoListException.class)
	public ResponseEntity<ErrorDto> todoListExceptionHandler(TodoListException exception) {
		ErrorDto error = new ErrorDto();
		error.setMessage(exception.getMessage());
		
		return new ResponseEntity<>(error, exception.getHttpStatus());
	}

}
