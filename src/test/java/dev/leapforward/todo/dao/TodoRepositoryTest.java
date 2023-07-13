package dev.leapforward.todo.dao;

import dev.leapforward.todo.model.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.Optional;

@DataJpaTest
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@EntityScan(basePackageClasses = Todo.class)
class TodoRepositoryTest {

    @Autowired
    private TodoRepository todoRepository;

    @Container
    @ServiceConnection
    private static PostgreSQLContainer postgresqlContainer = new PostgreSQLContainer("postgres:latest")
            .withDatabaseName("foo")
            .withUsername("foo")
            .withPassword("secret");

    @Test
    void findById() {


        Optional<Todo> todo = todoRepository.findById(1);
        todo.ifPresent(System.out::println);
    }
}