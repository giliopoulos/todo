package dev.leapforward.todo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest(
    properties = {
            "spring.jpa.hibernate.ddl-auto=validate",
    }
)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SchemaValidationTest extends AbstractContainerBaseTest {
 
    @Test
    public void testSchemaValidity() {}
     
}