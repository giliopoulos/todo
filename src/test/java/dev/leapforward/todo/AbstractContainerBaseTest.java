package dev.leapforward.todo;

import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;

public abstract class AbstractContainerBaseTest {

    @Container
    @ServiceConnection
    private static final PostgreSQLContainer<?> postgresqlContainer;

    static {
        postgresqlContainer = new PostgreSQLContainer<>("postgres:latest")
                .withDatabaseName("foo")
                .withUsername("foo")
                .withPassword("secret");

        postgresqlContainer.start();
    }
}
