package dev.leapforward.todo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "collaboration", schema = "todo_schema")
public class Collaboration {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "collaboration_seq")
    @SequenceGenerator(name = "collaboration_seq", schema = "todo_schema", sequenceName = "collaboration_collaboration_id_seq", allocationSize = 1)
    @Column(name = "collaboration_id", nullable = false)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "todo_id")
    private Todo todo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
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
        if (!(o instanceof Collaboration that)) return false;

        if (id != that.id) return false;
        if (!person.equals(that.person)) return false;
        return todo.equals(that.todo);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + person.hashCode();
        result = 31 * result + todo.hashCode();
        return result;
    }
}
