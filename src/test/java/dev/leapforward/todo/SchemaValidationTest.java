package dev.leapforward.todo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


//Custom enum type not working with ddl-auto=validate yet
@Disabled
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