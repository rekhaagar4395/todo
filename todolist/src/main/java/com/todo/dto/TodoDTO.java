package com.todo.dto;

import java.io.Serializable;

import com.todo.entity.TodoList;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodoDTO {
	private Long id;
	
	private String todo;
	
	private boolean taskCompleted;
	
	public static TodoDTO build(TodoList todo) {
		return TodoDTO.builder()
				.id(todo.getId())
				.todo(todo.getTodo())
				.taskCompleted(todo.isTaskCompleted())
				.build();
	}
}
