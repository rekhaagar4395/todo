package com.todo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.todo.dto.TodoDTO;
import com.todo.entity.TodoList;
import com.todo.exceptions.TodoListException;
import com.todo.repository.TodoListRepository;
import com.todo.services.impl.TodoListServiceImpl;

@ExtendWith(MockitoExtension.class)
public class TodoListServiceTest {
	
	@Mock
	private TodoListRepository todoListRepo;
	
	@InjectMocks
	private TodoListServiceImpl todoListService;
	
	private TodoList todoList;
	
	@BeforeEach
    public void setup(){
        
	   todoList = TodoList.builder()
                .id(1L)
                .todo("Gym")
                .taskCompleted(false)
                .build();
  
   }
	
	@Test
	public void createTodoList() {
		when(todoListRepo.save(todoList)).thenReturn(todoList); 
		TodoDTO todo = todoListService.createTodoList(TodoDTO.build(todoList));
		
        assertThat(todo).isNotNull();
        assertEquals(todoList.getTodo(), todo.getTodo());
	}
	
	@Test
	public void getTodoList() {
		TodoList todoList1 = TodoList.builder()
                .id(2L)
                .todo("Office work")
                .taskCompleted(false)
                .build();
		
		when(todoListRepo.findAll()).thenReturn(List.of(todoList, todoList1)); 
		
		List<TodoDTO> todo = todoListService.getTodoList();
		
        assertThat(todo).isNotNull();
        assertEquals(todo.size(),2);
	}
	
	@Test
	public void deleteTodoList_success() {	
	    Optional<TodoList> optionalEntityType = Optional.of(todoList);
	    Mockito.when(todoListRepo.findById(1L)).thenReturn(optionalEntityType);

	    // when
	    todoListService.removeTodoList(optionalEntityType.get().getId());

	    // then
	    Mockito.verify(todoListRepo, times(1)).delete(todoList);
	}
	
	@Test
	public void deleteTodoList_exception() {	
        long todoId = 2L;

        org.junit.jupiter.api.Assertions.assertThrows(TodoListException.class, () -> {
            todoListService.removeTodoList(todoId);
        });

        verify(todoListRepo, never()).delete(todoList);
	}

}
