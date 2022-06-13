package com.todo.exceptions;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
public class TodoListException extends RuntimeException {
	private HttpStatus httpStatus;
	
	public TodoListException(String message) {
		super(message);
	}
	
	public TodoListException(String message, HttpStatus httpStatus) {
		super(message);
		this.httpStatus = httpStatus;
	}
	
}
