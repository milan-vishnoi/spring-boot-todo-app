package com.example.myspringapp.todo.service;

import com.example.myspringapp.todo.dto.CreateTodoRequest;
import com.example.myspringapp.todo.dto.TodoResponse;

public interface TodoService {

    TodoResponse createTodo(CreateTodoRequest request);

}
