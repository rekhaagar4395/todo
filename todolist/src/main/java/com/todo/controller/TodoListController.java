package com.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.dto.TodoDTO;
import com.todo.services.TodoListService;


/**
 * 
 * @author rekhaagarwal
 *
 */

@RestController
@RequestMapping("/todo")
@CrossOrigin(allowedHeaders = "*")
public class TodoListController {
	
	@Autowired
	private TodoListService todoListService;
	
	@GetMapping
	public ResponseEntity<List<TodoDTO>> getTodoListOfUser() {
		return new ResponseEntity<>(todoListService.getTodoList(), HttpStatus.OK);
		
	}
	
	@PostMapping
	public ResponseEntity<TodoDTO> createTodoList(@RequestBody TodoDTO todo) {
		return new ResponseEntity<>(todoListService.createTodoList(todo), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{todoId}")
	public void removeTodoList(@PathVariable(name = "todoId") Long id) {
		todoListService.removeTodoList(id);
		
	}
	
}
