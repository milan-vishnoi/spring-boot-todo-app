package com.example.myspringapp.todo.repository;

import com.example.myspringapp.todo.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
