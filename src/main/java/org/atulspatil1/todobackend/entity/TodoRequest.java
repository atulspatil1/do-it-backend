package org.atulspatil1.todobackend.entity;

public class TodoRequest {

    private String title;
    private Boolean completed;

    public TodoRequest() {
    }

    public TodoRequest(String title) {
        this.title = title;
    }

    public TodoRequest(Boolean completed) {
        this.completed = completed;
    }

    public TodoRequest(String title, Boolean completed) {
        this.title = title;
        this.completed = completed;
    }

    public String getTitle() {
        return title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "TodoRequest{" +
                "title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }
}
