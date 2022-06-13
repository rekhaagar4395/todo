package com.todo.services;

import java.util.List;

import com.todo.dto.TodoDTO;

public interface TodoListService {

	List<TodoDTO> getTodoList();

	TodoDTO createTodoList(TodoDTO todo);

	void removeTodoList(Long id);

}
