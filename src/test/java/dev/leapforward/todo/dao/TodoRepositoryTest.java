package dev.leapforward.todo.dao;

import dev.leapforward.todo.AbstractContainerBaseTest;
import dev.leapforward.todo.model.Todo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TodoRepositoryTest extends AbstractContainerBaseTest {

    @Autowired
    private TodoRepository todoRepository;

    @Test
    void findById() {
        Optional<Todo> todo = todoRepository.findById(1);

        Assertions.assertTrue(todo.isPresent());
    }
}