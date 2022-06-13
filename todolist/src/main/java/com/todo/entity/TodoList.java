package com.todo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.todo.dto.TodoDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@Table(name = "todo_list")
@NoArgsConstructor
@AllArgsConstructor
public class TodoList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String todo;
	
	@Column(name = "task_completed", columnDefinition="tinyint(1) default 1")
	private boolean taskCompleted = false;
	
	public static TodoList build(TodoDTO todo) {
		return TodoList.builder()
				.id(todo.getId())
				.todo(todo.getTodo())
				.taskCompleted(todo.isTaskCompleted())
				.build();
	}

}
