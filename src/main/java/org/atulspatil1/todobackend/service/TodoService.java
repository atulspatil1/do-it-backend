package org.atulspatil1.todobackend.service;

import org.atulspatil1.todobackend.entity.Todo;
import org.atulspatil1.todobackend.entity.TodoRequest;
import org.atulspatil1.todobackend.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository repository;

    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    // Create Todo
    public Todo createTodo(String title) {
        Todo todo = new Todo(title, false);
        return repository.save(todo);
    }

    // Get Todo by id
    public Todo getTodo(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found"));
    }

    // Get Todo by staus
    public List<Todo> getTodosByStatus(Boolean completed) {
        if (completed == null) {
            return repository.findAll();
        }
        return repository.findByCompleted(completed);
    }

    //
    public Todo toogleTodo(Long id, boolean completed) {
        Todo todo = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found"));
        todo.setCompleted(completed);
        return repository.save(todo);
    }

    // Update todo
    public Todo updateTodo(Long id, TodoRequest todoRequest) {
        Todo todo = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found"));

        if (todoRequest.getTitle() != null)
            todo.setTitle(todoRequest.getTitle());
        if (todoRequest.getCompleted() != null)
            todo.setCompleted(todoRequest.getCompleted());

        return repository.save(todo);
    }

    // Delete todo
    public void deleteTodo(Long id) {
        repository.deleteById(id);
    }
}
