package dev.leapforward.todo.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.StringJoiner;

@Entity
@Table(name = "reminder", schema = "todo_schema")
public class Reminder {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "reminder_id", nullable = false)
    private int id;
    @Basic
    @Column(name = "reminder_date", nullable = false)
    private LocalDate reminderDate;
    @Basic
    @Column(name = "reminder_time", nullable = false)
    private LocalTime reminderTime;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "todo_id")
    private Todo todo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getReminderDate() {
        return reminderDate;
    }

    public void setReminderDate(LocalDate reminderDate) {
        this.reminderDate = reminderDate;
    }

    public LocalTime getReminderTime() {
        return reminderTime;
    }

    public void setReminderTime(LocalTime reminderTime) {
        this.reminderTime = reminderTime;
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
        if (!(o instanceof Reminder reminder)) return false;

        if (id != reminder.id) return false;
        if (!reminderDate.equals(reminder.reminderDate)) return false;
        if (!reminderTime.equals(reminder.reminderTime)) return false;
        return todo.equals(reminder.todo);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + reminderDate.hashCode();
        result = 31 * result + reminderTime.hashCode();
        result = 31 * result + todo.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Reminder.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("reminderDate=" + reminderDate)
                .add("reminderTime=" + reminderTime)
                .toString();
    }
}
