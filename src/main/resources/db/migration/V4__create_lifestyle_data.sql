CREATE TABLE lifestyle_data(
                               id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                               user_id BIGINT NOT NULL REFERENCES users(id),
                               record_date DATE NOT NULL,
                               weight DECIMAL,
                               height DECIMAL,
                               exercise_type VARCHAR(100),
                               exercise_duration DECIMAL,
                               fatigue_level VARCHAR(20) CHECK(fatigue_level IN ('MILD','MODERATE','SEVERE')),
                               is_relaxed BOOLEAN,
                               relax_activity VARCHAR(100),
                               diet_note TEXT,
                               created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                               UNIQUE (user_id, record_date)
);