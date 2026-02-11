package org.atulspatil1.todobackend.service;

import org.atulspatil1.todobackend.entity.Todo;
import org.atulspatil1.todobackend.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository repository;

    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public Todo createTodo(String title) {
        Todo todo = Todo.builder()
                .title(title)
                .completed(false)
                .build();
        return repository.save(todo);
    }

    public List<Todo> getTodosByStatus(Boolean completed) {
        if(completed == null) {
            return repository.findAll();
        }
        return repository.findByCompleted(completed);
    }

    public Todo toogleTodo(Long id, boolean completed) {
        Todo todo = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("To do not found"));
        todo.setCompleted(completed);
        return repository.save(todo);
    }

    public void deleteTodo(Long id) {
        repository.deleteById(id);
    }
}
