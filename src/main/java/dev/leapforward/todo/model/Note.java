package dev.leapforward.todo.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.StringJoiner;

@Entity
@Table(name = "note", schema = "todo_schema")
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "todo_id")
    private Todo todo;

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

    public Todo getTodo() {
        return todo;
    }

    public void setTodo(Todo todo) {
        this.todo = todo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Note note)) return false;

        if (id != note.id) return false;
        if (!content.equals(note.content)) return false;
        if (!createdAt.equals(note.createdAt)) return false;
        return todo.equals(note.todo);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + content.hashCode();
        result = 31 * result + createdAt.hashCode();
        result = 31 * result + todo.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Note.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("content='" + content + "'")
                .add("createdAt=" + createdAt)
                .toString();
    }
}
