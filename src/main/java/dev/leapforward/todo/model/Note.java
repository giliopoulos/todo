package dev.leapforward.todo.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Note {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "note_id", nullable = false)
    private int id;
    @Basic
    @Column(name = "content", nullable = false, length = -1)
    private String content;
    @Basic
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Basic
    @Column(name = "todo_id", nullable = false)
    private int todoId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public int getTodoId() {
        return todoId;
    }

    public void setTodoId(int todoId) {
        this.todoId = todoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Note note = (Note) o;

        if (id != note.id) return false;
        if (todoId != note.todoId) return false;
        if (content != null ? !content.equals(note.content) : note.content != null) return false;
        if (createdAt != null ? !createdAt.equals(note.createdAt) : note.createdAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + todoId;
        return result;
    }
}
