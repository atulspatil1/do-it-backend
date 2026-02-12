package org.atulspatil1.todobackend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "doit")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private Boolean completed;

    public Todo() {
    }

    public Todo(String title, Boolean completed) {
        this.title = title;
        this.completed = completed;
    }

    public Todo(Long id, String title, Boolean completed) {
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Todo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }
}
