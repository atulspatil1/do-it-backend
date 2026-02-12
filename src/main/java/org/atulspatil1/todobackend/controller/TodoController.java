package org.atulspatil1.todobackend.controller;

import org.atulspatil1.todobackend.entity.Todo;
import org.atulspatil1.todobackend.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    // Create Todo
    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {
        return todoService.createTodo(todo.getTitle());
    }

    // Get Todos (all / active / completed)
    @GetMapping
    public List<Todo> getTodos(
            @RequestParam(required = false) Boolean completed) {
        return todoService.getTodosByStatus(completed);
    }

    // Update todo
    @PutMapping("/{id}")
    public Todo updateTodoStatus(
            @PathVariable Long id,
            @RequestParam boolean completed) {
        return todoService.toogleTodo(id, completed);
    }

    // Delete todo
    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
    }
}
