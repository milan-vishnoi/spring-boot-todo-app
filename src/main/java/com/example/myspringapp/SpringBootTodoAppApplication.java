package com.example.myspringapp;

import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.myspringapp.todo.mcp.TodoMcpTools;

@SpringBootApplication
public class SpringBootTodoAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTodoAppApplication.class, args);
    }

    @Bean
    ToolCallbackProvider toolCallbackProvider(TodoMcpTools todoMcpTools) {
        return MethodToolCallbackProvider.builder().toolObjects(todoMcpTools).build();

    }

}
