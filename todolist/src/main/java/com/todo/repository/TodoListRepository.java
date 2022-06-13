package com.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todo.entity.TodoList;

@Repository
public interface TodoListRepository extends JpaRepository<TodoList, Long> {

}
