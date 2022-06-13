package com.todo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(classes = TodolistApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class TodolistApplicationTests {

	@Test
	void contextLoads() {
	}

}
