package dev.leapforward.todo.model;

import io.hypersistence.utils.hibernate.type.basic.PostgreSQLEnumType;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import java.time.LocalDateTime;
import java.util.StringJoiner;

@Entity
@Table(name = "todo", schema = "todo_schema")
public class Todo {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "todo_id", nullable = false)
    private int id;
    @Basic
    @Column(name = "title", nullable = false)
    private String title;
    @Basic
    @Column(name = "description", length = -1)
    private String description;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    @Type(PostgreSQLEnumType.class)
    private TodoStatus status;
    @Basic
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Basic
    @Column(name = "completed_at", nullable = true)
    private LocalDateTime completedAt;
    @Basic
    @Column(name = "person_id", nullable = false)
    private int personId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TodoStatus getStatus() {
        return status;
    }

    public void setStatus(TodoStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(LocalDateTime completedAt) {
        this.completedAt = completedAt;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Todo todo = (Todo) o;

        if (id != todo.id) return false;
        if (personId != todo.personId) return false;
        if (title != null ? !title.equals(todo.title) : todo.title != null) return false;
        if (description != null ? !description.equals(todo.description) : todo.description != null) return false;
        if (status != null ? !status.equals(todo.status) : todo.status != null) return false;
        if (createdAt != null ? !createdAt.equals(todo.createdAt) : todo.createdAt != null) return false;
        if (completedAt != null ? !completedAt.equals(todo.completedAt) : todo.completedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (completedAt != null ? completedAt.hashCode() : 0);
        result = 31 * result + personId;
        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Todo.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("title='" + title + "'")
                .add("description='" + description + "'")
                .add("status=" + status)
                .add("createdAt=" + createdAt)
                .add("completedAt=" + completedAt)
                .add("personId=" + personId)
                .toString();
    }
}
