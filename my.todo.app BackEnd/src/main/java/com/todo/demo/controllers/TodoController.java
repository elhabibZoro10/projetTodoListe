package com.todo.demo.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.todo.demo.entities.Todo;
import com.todo.demo.services.TodoService;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/todos")
public class TodoController {
	@Autowired
	TodoService todoService;
	
	@PostMapping(path="/{title}", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Todo> createTodo(@PathVariable String title) throws Exception{
		Todo todo = todoService.createTodo(title);
        return new ResponseEntity<Todo>(todo, HttpStatus.CREATED);
    }
	
	@PutMapping(path="/completed/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> markTodoCompleted(@PathVariable Long id) throws Exception{
		todoService.markTodoCompleted(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
	

	@PutMapping(path="/uncompleted/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> markTodoUncompleted(@PathVariable Long id) throws Exception{
		todoService.markTodoUncompleted(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
	
	
	@DeleteMapping(path="/{id}")
    public ResponseEntity<Object> deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Todo>> getAllTodos() {
		List<Todo> todos=todoService.listTodos();
        return new ResponseEntity<List<Todo>>(todos, HttpStatus.OK);
    }
	
}
