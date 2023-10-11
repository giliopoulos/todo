package dev.leapforward.todo.dao;

import dev.leapforward.todo.model.Reminder;
import dev.leapforward.todo.model.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo, Integer> {

    Page<Todo> findTodosByPersonId(int id, Pageable page);
}