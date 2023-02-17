package com.todo.demo.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.demo.entities.Todo;
import com.todo.demo.repositories.TodoRepository;
import com.todo.demo.services.TodoService;

@Service
public class TodoServiceImpl implements TodoService {
	@Autowired
	TodoRepository todoRepository;

	@Override
	public Todo createTodo(String title) {
		Todo todo = new Todo(title);
		return todoRepository.save(todo);
	}

	@Override
	public void markTodoCompleted(Long id) {
		Todo todo = todoRepository.findTodoById(id);
		todo.setCompleted(true);
		todoRepository.save(todo);
	}

	@Override
	public void markTodoUncompleted(Long id) {
		Todo todo = todoRepository.findTodoById(id);
		todo.setCompleted(false);
		todoRepository.save(todo);
	}

	@Override
	public void deleteTodo(Long id) {
		Todo todo = todoRepository.findTodoById(id);
		todoRepository.delete(todo);
	}

	@Override
	public List<Todo> listTodos() {
		List<Todo> todos = todoRepository.findAll();
		return todos;
	}

}
