package dev.leapforward.todo.dao;

import dev.leapforward.todo.AbstractContainerBaseTest;
import dev.leapforward.todo.model.Todo;
import dev.leapforward.todo.model.TodoStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TodoRepositoryTest extends AbstractContainerBaseTest {

    @Autowired
    private TodoRepository todoRepository;

    @Test
    void should_bePresent_when_dbIsSetup() {
        Optional<Todo> todo = todoRepository.findById(1);

        assertTrue(todo.isPresent());
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
    void should_saveNewTodo() {
        Todo todo = new Todo();
        todo.setStatus(TodoStatus.PENDING);
        todo.setTitle("Test tile");
        todo.setDescription("A test description");
        //todo.setPerson();

        System.out.println("Before save: " + todo);
        Todo saved = todoRepository.save(todo);
        System.out.println("After save: " + saved);
        System.out.println(saved.getId());

        Todo todo1 = new Todo();
        todo1.setStatus(TodoStatus.PENDING);
        todo1.setTitle("Test 2");
        todo1.setDescription("A test description");

        Todo saved1 = todoRepository.save(todo1);
        System.out.println("After save: " + saved1);


    }
}