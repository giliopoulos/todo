package dev.leapforward.todo.model;

import jakarta.persistence.*;

@Entity
public class Collaboration {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "collaboration_id", nullable = false)
    private int id;
    @Basic
    @Column(name = "person_id", nullable = false)
    private int personId;
    @Basic
    @Column(name = "todo_id", nullable = false)
    private int todoId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
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

        Collaboration that = (Collaboration) o;

        if (id != that.id) return false;
        if (personId != that.personId) return false;
        if (todoId != that.todoId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + personId;
        result = 31 * result + todoId;
        return result;
    }
}
