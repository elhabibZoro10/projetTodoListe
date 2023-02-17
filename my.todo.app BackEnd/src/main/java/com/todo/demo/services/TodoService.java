package com.todo.demo.services;

import java.util.List;

import com.todo.demo.entities.Todo;

public interface TodoService {
	Todo createTodo(String title);
	void markTodoCompleted(Long id);
	void markTodoUncompleted(Long id);
	void deleteTodo(Long id);
	List<Todo> listTodos();
}
