package dev.leapforward.todo.dao;

import dev.leapforward.todo.AbstractContainerBaseTest;
import dev.leapforward.todo.model.Person;
import dev.leapforward.todo.model.Todo;
import dev.leapforward.todo.model.TodoStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest(showSql = false)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TodoRepositoryTest extends AbstractContainerBaseTest {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private PersonRepository personRepository;

    @Test
    void should_bePresent_when_dbIsSetup() {
        Long count = todoRepository.count();

        assertEquals(3,count);
    }

    @Test
    void should_find2Todos_when_personIdIs1() {
        Page<Todo> todosByPerson = todoRepository.findTodosByPersonId(1, PageRequest.of(0, 10));

        assertEquals(2, todosByPerson.getTotalElements());
        assertEquals(0, todosByPerson.getNumber());
        assertEquals(1, todosByPerson.getTotalPages());
        assertTrue(todosByPerson.isLast());
    }

    @Test
    void should_throwException_when_PersonNotSpecified() {
        Todo todo = new Todo();
        todo.setStatus(TodoStatus.PENDING);
        todo.setTitle("Test tile");
        todo.setDescription("A test description");

        Assertions.assertThrows(DataIntegrityViolationException.class, () -> todoRepository.saveAndFlush(todo));
    }

    @Test
    void should_saveNewTodoForPersonWithId() {

        Person person = personRepository.getReferenceById(1);

        Todo todo = new Todo();
        todo.setStatus(TodoStatus.PENDING);
        todo.setTitle("Test tile");
        todo.setDescription("A test description");
        todo.setPerson(person);

        todoRepository.save(todo);

        assertEquals(3, todoRepository.findTodosByPersonId(1,PageRequest.of(0, 10)).getTotalElements());
    }
}