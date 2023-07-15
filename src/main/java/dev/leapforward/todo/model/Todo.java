package dev.leapforward.todo.model;

import io.hypersistence.utils.hibernate.type.basic.PostgreSQLEnumType;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import java.time.LocalDateTime;
import java.util.Objects;
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

    //@Fetch(FetchMode.JOIN)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;

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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Todo todo)) return false;

        if (id != todo.id) return false;
        if (!Objects.equals(title, todo.title)) return false;
        if (!Objects.equals(description, todo.description)) return false;
        if (status != todo.status) return false;
        if (!Objects.equals(createdAt, todo.createdAt)) return false;
        if (!Objects.equals(completedAt, todo.completedAt)) return false;
        return Objects.equals(person, todo.person);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (completedAt != null ? completedAt.hashCode() : 0);
        result = 31 * result + (person != null ? person.hashCode() : 0);
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
                .add("person=" + person)
                .toString();
    }
}
