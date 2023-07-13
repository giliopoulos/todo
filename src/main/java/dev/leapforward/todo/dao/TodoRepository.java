package dev.leapforward.todo.dao;

import dev.leapforward.todo.model.Todo;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface TodoRepository extends PagingAndSortingRepository<Todo, Integer> {

    Optional<Todo> findById(int id);
}