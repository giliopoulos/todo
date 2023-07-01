package dev.leapforward.todo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.ApplicationContext;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
@Testcontainers
class TodoApplicationTests {

	@Container
	@ServiceConnection
	private static PostgreSQLContainer postgresqlContainer = new PostgreSQLContainer("postgres:latest")
			.withDatabaseName("foo")
			.withUsername("foo")
			.withPassword("secret");

/*	@DynamicPropertySource
	private static void setupProperties(DynamicPropertyRegistry registry) {
		registry.add("spring.datasource.url", postgresqlContainer::getJdbcUrl);
		registry.add("spring.datasource.username", postgresqlContainer::getUsername);
		registry.add("spring.datasource.password", postgresqlContainer::getPassword);
	}*/
	@Test
	void contextLoads(ApplicationContext context) {
		Assertions.assertNotNull(context);
	}

}
