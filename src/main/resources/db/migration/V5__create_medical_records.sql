CREATE TABLE medical_records(
                                id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                                user_id BIGINT NOT NULL REFERENCES users(id),
                                doctor_id BIGINT NOT NULL REFERENCES users(id),
                                visit_date DATE NOT NULL,
                                diagnosis TEXT,
                                symptoms TEXT,
                                notes TEXT,
                                created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE medication_records(
                                   id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                                   medical_record_id BIGINT NOT NULL REFERENCES medical_records(id),
                                   drug_name VARCHAR(100),
                                   dosage VARCHAR(50),
                                   frequency VARCHAR(100),
                                   duration_days INTEGER,
                                   created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);