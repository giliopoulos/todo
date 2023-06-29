-- Shcema notes
-- --------------------
-- Serial is chosen as a type for primary keys
-- todo_status is an enum
-- TIMESTAMPTZ is chosen over TIMESTAMP so it includes timezone info
-- A person can have 0..N todos. A todo belongs to exactly one person
-- A todo can have collaborators (which are also persons)
-- The collaboration table describes the many to many relationship between persons and todos
-- A person cannot collaborate twice on the same todo (unique constraint)
-- A todo can have many notes
-- A todo can have many reminders
-- When a todo gets deleted the notes get deleted too
-- When a todo gets deleted the reminders get deleted too
-- When a person gets deleted the todos and collaborations get deleted too
--

CREATE TABLE person
(
    person_id SERIAL PRIMARY KEY,
    name      VARCHAR(100)        NOT NULL,
    surname   VARCHAR(100)        NOT NULL,
    email     VARCHAR(255) UNIQUE NOT NULL,
    password  VARCHAR(255)        NOT NULL
);

CREATE TYPE todo_status_enum AS ENUM ('pending', 'completed');

CREATE TABLE todo
(
    todo_id      SERIAL PRIMARY KEY,
    title        VARCHAR(255)     NOT NULL,
    description  TEXT,
    status       todo_status_enum NOT NULL,
    created_at   TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
    completed_at TIMESTAMPTZ,
    person_id    INT              NOT NULL,
    FOREIGN KEY (person_id) REFERENCES person (person_id) ON DELETE CASCADE
);

CREATE TABLE collaboration
(
    collaboration_id SERIAL PRIMARY KEY,
    person_id        INT NOT NULL,
    todo_id          INT NOT NULL,
    FOREIGN KEY (person_id) REFERENCES person (person_id) ON DELETE CASCADE,
    FOREIGN KEY (todo_id) REFERENCES todo (todo_id) ON DELETE CASCADE,
    CONSTRAINT unique_collaboration UNIQUE (person_id, todo_id)
);

CREATE TABLE note
(
    note_id    SERIAL PRIMARY KEY,
    content    TEXT NOT NULL,
    created_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
    todo_id    INT  NOT NULL,
    FOREIGN KEY (todo_id) REFERENCES todo (todo_id) ON DELETE CASCADE
);

CREATE TABLE reminder
(
    reminder_id   SERIAL PRIMARY KEY,
    reminder_date DATE NOT NULL,
    reminder_time TIME NOT NULL,
    todo_id       INT  NOT NULL,
    FOREIGN KEY (todo_id) REFERENCES todo (todo_id) ON DELETE CASCADE
);


