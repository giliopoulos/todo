package dev.leapforward.todo.dao;

import dev.leapforward.todo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}