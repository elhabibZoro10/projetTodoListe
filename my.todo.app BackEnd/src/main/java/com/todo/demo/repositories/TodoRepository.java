package com.todo.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todo.demo.entities.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    Todo findTodoById(Long id);
}