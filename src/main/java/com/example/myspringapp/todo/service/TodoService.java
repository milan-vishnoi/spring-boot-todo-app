package com.example.myspringapp.todo.service;

import java.util.List;

import com.example.myspringapp.todo.dto.CreateTodoRequest;
import com.example.myspringapp.todo.dto.TodoResponse;

public interface TodoService {

    TodoResponse createTodo(CreateTodoRequest request);

    List<TodoResponse> getAllTodos();

}
