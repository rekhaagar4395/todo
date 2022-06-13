package com.todo.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.todo.dto.TodoDTO;
import com.todo.entity.TodoList;
import com.todo.exceptions.TodoListException;
import com.todo.repository.TodoListRepository;
import com.todo.services.TodoListService;
/**
 * 
 * @author rekhaagarwal
 *
 */

@Service
public class TodoListServiceImpl implements TodoListService {

	@Autowired
	private TodoListRepository todoListRepo;
	
	@Override
	public List<TodoDTO> getTodoList() {
		List<TodoList> todoList = todoListRepo.findAll();
		return todoList.stream().map(todo -> TodoDTO.build(todo)).collect(Collectors.toList());	
	}
	
	@Override
	public TodoDTO createTodoList(TodoDTO todo) {
		TodoList todoList = todoListRepo.save(TodoList.build(todo));
		return TodoDTO.build(todoList);
	}
	
//	public TodoDTO updateTodoList(TodoDTO todo) {
//		Optional<TodoList> todoList = todoListRepo.findById(todo.getId());
//
//		if(todoList.isEmpty()) {
//			throw new TodoListException("Todo with id "+ todo.getTodo() + " Not Found.", HttpStatus.NOT_FOUND);
//		}
//		TodoList todoEntity = todoList.get();
//		if(StringUtils.hasText(todo.getTodo())) {
//			todoEntity.setTodo(todo.getTodo());
//		}
//		
//		TodoList savetodoList = todoListRepo.save(todoEntity);
//		return TodoDTO.build(savetodoList);
//	}
//	

	@Override
	public void removeTodoList(Long id) {
		Optional<TodoList> todo = todoListRepo.findById(id);
		if(todo.isEmpty()) {
			throw new TodoListException("Todo with id "+ id + " Not Found.", HttpStatus.NOT_FOUND);
		}
		todoListRepo.delete(todo.get());		
	}

	
}
