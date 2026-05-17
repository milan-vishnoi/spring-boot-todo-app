package com.example.myspringapp.todo.service;

import java.util.List;

import com.example.myspringapp.todo.dto.CreateTodoRequest;
import com.example.myspringapp.todo.dto.TodoResponse;
import com.example.myspringapp.todo.dto.UpdateTodoRequest;

public interface TodoService {

    TodoResponse createTodo(CreateTodoRequest request);

    List<TodoResponse> getAllTodos();

    TodoResponse getTodoById(Long id);

    TodoResponse updateTodo(Long id, UpdateTodoRequest request);

    void deleteTodo(Long id);

}
