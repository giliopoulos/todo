--liquibase formatted sql
--changeset giliopoulos:2 contextFilter:local-dev,integration-tests


SET SEARCH_PATH = todo_schema;

-- Insert initial data into the 'person' table
INSERT INTO person (name, surname, email, password)
VALUES
    ('John', 'Doe', 'john.doe@example.com', 'password1'),
    ('Jane', 'Smith', 'jane.smith@example.com', 'password2');

-- Insert initial data into the 'todo' table
INSERT INTO todo (title, description, status, created_at, person_id)
VALUES
    ('Task 1', 'This is task 1', 'PENDING', '2023-07-01 16:08:21.111427 +00:00',1),
    ('Task 2', 'This is task 2', 'COMPLETED', '2023-07-01 16:08:21.111427 +00:00', 1),
    ('Task 3', 'This is task 3', 'PENDING', '2023-07-01 16:08:21.111427 +00:00', 2);

-- Insert initial data into the 'notes' table
INSERT INTO note (content, todo_id)
VALUES
    ('Note for Task 1', 1),
    ('Note for Task 1', 1),
    ('Note for Task 2', 2);

-- Insert initial data into the 'reminder' table
INSERT INTO reminder (reminder_date, reminder_time, todo_id)
VALUES
    ('2023-06-01','18:00:00', 1),
    ('2023-06-02', '15:00:00',2);


-- Insert initial data into the 'collaboration' table
INSERT INTO collaboration (person_id, todo_id)
VALUES
    (1, 1), -- Person 1 collaborates on Todo 1
    (1, 2), -- Person 1 collaborates on Todo 2
    (2, 1), -- Person 2 collaborates on Todo 1
    (2, 3); -- Person 2 collaborates on Todo 3

