package dev.leapforward.todo.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
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
    @Basic
    @Column(name = "todo_id", nullable = false)
    private int todoId;

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

        Reminder reminder = (Reminder) o;

        if (id != reminder.id) return false;
        if (todoId != reminder.todoId) return false;
        if (reminderDate != null ? !reminderDate.equals(reminder.reminderDate) : reminder.reminderDate != null)
            return false;
        if (reminderTime != null ? !reminderTime.equals(reminder.reminderTime) : reminder.reminderTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (reminderDate != null ? reminderDate.hashCode() : 0);
        result = 31 * result + (reminderTime != null ? reminderTime.hashCode() : 0);
        result = 31 * result + todoId;
        return result;
    }
}
