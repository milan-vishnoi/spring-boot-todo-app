package com.example.myspringapp.todo.mcp;

import java.time.LocalDate;
import java.util.List;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

import com.example.myspringapp.todo.domain.TodoStatus;
import com.example.myspringapp.todo.dto.CreateTodoRequest;
import com.example.myspringapp.todo.dto.TodoResponse;
import com.example.myspringapp.todo.dto.UpdateTodoRequest;
import com.example.myspringapp.todo.service.TodoService;

@Component
public class TodoMcpTools {

    private final TodoService todoService;

    public TodoMcpTools(TodoService todoService) {
        this.todoService = todoService;
    }

    @Tool(name = "create_todo", description = "Create/Add a todo item")
    public TodoResponse createTodo(
            @ToolParam(description = "Todo title", required = true) String title,
            @ToolParam(description = "Todo description", required = false) String description,
            @ToolParam(description = "Todo status", required = false) TodoStatus status,
            @ToolParam(description = "Todo due date in yyyy-MM-dd format", required = false) LocalDate dueDate) {
        CreateTodoRequest request = new CreateTodoRequest();
        request.setTitle(title);
        request.setDescription(description);
        request.setStatus(status == null ? TodoStatus.PENDING : status);
        request.setDueDate(dueDate);

        return todoService.createTodo(request);
    }

    @Tool(name = "get_all_todos", description = "Return all todo items")
    public List<TodoResponse> getAllTodos() {
        return todoService.getAllTodos();
    }

    @Tool(name = "get_todo_by_id", description = "Get a todo by id")
    public TodoResponse getTodoById(
            @ToolParam(description = "Todo id", required = true) Long id
    ) {
        return todoService.getTodoById(id);
    }

    @Tool(name = "update_todo", description = "Update an existing todo")
    public TodoResponse updateTodo(
            @ToolParam(description = "Todo id", required = true) Long id,
            @ToolParam(description = "Todo title", required = false) String title,
            @ToolParam(description = "Todo description", required = false) String description,
            @ToolParam(description = "Todo status", required = false) TodoStatus status,
            @ToolParam(description = "Todo due date in yyyy-MM-dd format", required = false) LocalDate dueDate
    ) {
        UpdateTodoRequest request = new UpdateTodoRequest();
        request.setTitle(title);
        request.setDescription(description);
        request.setStatus(status);
        request.setDueDate(dueDate);
        return todoService.updateTodo(id, request);
    }

    @Tool(name = "delete_todo", description = "Delete a todo by id")
    public String deleteTodo(
            @ToolParam(description = "Todo id", required = true) Long id
    ) {
        todoService.deleteTodo(id);
        return "Deleted todo " + id;
    }

}
