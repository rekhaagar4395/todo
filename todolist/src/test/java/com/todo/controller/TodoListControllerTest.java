//package com.todo.controller;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.test.web.server.LocalServerPort;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import com.todo.TodolistApplicationTests;
//import com.todo.dto.TodoDTO;
//import com.todo.entity.TodoList;
//import com.todo.repository.TodoListRepository;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.util.List;
//
//class TodoListControllerTest extends TodolistApplicationTests {
//
//	@Autowired
//	private TodoListRepository todoRepository;
//	
//	protected TestRestTemplate restTemplate = new TestRestTemplate();
//
//	@LocalServerPort
//	private Integer port;
//
//	protected String getUrl(String uri) {
//		return new StringBuilder("http://localhost:").append(this.port).append(uri).toString();
//	}
//	
//    @Test
//    void getTodoListOfUser() {
//    	TodoList todoList = TodoList.builder()
//                .id(1L)
//                .todo("Gym")
//                .taskCompleted(false)
//                .build();
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Content-Type","application/json");
//		String urlEnroll = getUrl(new StringBuilder("/todo").toString());
//		HttpEntity<TodoDTO> entity = new HttpEntity(TodoDTO.build(todoList), headers);
//		restTemplate.exchange(urlEnroll, HttpMethod.POST, entity, TodoDTO.class);
//		
//		List<TodoDTO> todo = restTemplate.exchange(urlEnroll, HttpMethod.GET, .class);
//
//		
//		
//		assertEquals(HttpStatus.OK.value(), res.getStatusCodeValue());
//		assertEquals(false, res.getBody().isTaskCompleted());
//    }
//
//    @Test
//    void createTodoList() {
//    	TodoList todoList = TodoList.builder()
//                .id(1L)
//                .todo("Gym")
//                .taskCompleted(false)
//                .build();
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Content-Type","application/json");
//		String urlEnroll = getUrl(new StringBuilder("/todo").toString());
//		HttpEntity<TodoDTO> entity = new HttpEntity(TodoDTO.build(todoList), headers);
//		ResponseEntity<TodoDTO> res = restTemplate.exchange(urlEnroll, HttpMethod.POST, entity, TodoDTO.class);
//		assertEquals(HttpStatus.OK.value(), res.getStatusCodeValue());
//		assertEquals(false, res.getBody().isTaskCompleted());
//    }
//
//    @Test
//    void removeTodoList() {
//    }
//}