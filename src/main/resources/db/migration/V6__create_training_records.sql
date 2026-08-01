CREATE TABLE training_records(
                                 id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                                 user_id BIGINT NOT NULL REFERENCES users(id),
                                 coach_id BIGINT NOT NULL REFERENCES users(id),
                                 training_date DATE NOT NULL,
                                 coach_notes TEXT,
                                 created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE training_exercises(
                                   id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                                   training_record_id BIGINT NOT NULL REFERENCES training_records(id),
                                   exercise_name VARCHAR(200) NOT NULL,
                                   sets INTEGER NOT NULL,
                                   reps INTEGER NOT NULL,
                                   weight DECIMAL NOT NULL,
                                   created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);