package dev.leapforward.todo.dao;

import dev.leapforward.todo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo, Integer> {

    Optional<Todo> findById(int id);
}