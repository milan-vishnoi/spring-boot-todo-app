package com.example.myspringapp.todo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.myspringapp.common.exception.ResourceNotFoundException;
import com.example.myspringapp.todo.domain.Todo;
import com.example.myspringapp.todo.domain.TodoStatus;
import com.example.myspringapp.todo.dto.CreateTodoRequest;
import com.example.myspringapp.todo.dto.TodoResponse;
import com.example.myspringapp.todo.dto.UpdateTodoRequest;
import com.example.myspringapp.todo.mapper.TodoMapper;
import com.example.myspringapp.todo.repository.TodoRepository;

@Service
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;
    private final TodoMapper todoMapper;

    public TodoServiceImpl(TodoRepository todoRepository, TodoMapper todoMapper) {
        this.todoRepository = todoRepository;
        this.todoMapper = todoMapper;
    }

    @Override
    public TodoResponse createTodo(CreateTodoRequest request) {
        Todo todo = new Todo();
        todo.setTitle(request.getTitle().trim());
        todo.setDescription(request.getDescription());
        todo.setStatus(request.getStatus() == null ? TodoStatus.PENDING : request.getStatus());
        todo.setDueDate(request.getDueDate());

        Todo savedTodo = todoRepository.save(todo);
        return todoMapper.toResponse(savedTodo);
    }

    @Override
    public List<TodoResponse> getAllTodos() {
        return todoRepository.findAll().stream().map(todoMapper::toResponse).toList();

    }

    @Override
    public TodoResponse getTodoById(Long id) {
        Todo todo = findTodoById(id);
        return todoMapper.toResponse(todo);

    }

    @Override
    public TodoResponse updateTodo(Long id, UpdateTodoRequest request) {
        Todo todo = findTodoById(id);
        todo.setTitle(request.getTitle().trim());
        todo.setDescription(request.getDescription());
        todo.setStatus(request.getStatus() == null ? TodoStatus.PENDING : request.getStatus());
        todo.setDueDate(request.getDueDate());

        Todo updatedTodo = todoRepository.save(todo);
        return todoMapper.toResponse(updatedTodo);

    }

    @Override
    public void deleteTodo(Long id) {
        Todo todo = findTodoById(id);
        todoRepository.delete(todo);
    }

    private Todo findTodoById(Long id) {
        return todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id: " + id));
    }
}
