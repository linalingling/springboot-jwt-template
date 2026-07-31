CREATE TABLE allergies(
                          id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                          user_id   BIGINT NOT NULL REFERENCES users(id),
                          allergen  VARCHAR(50) NOT NULL,
                          clinical_notes VARCHAR(100),
                          diagnosed_by BIGINT NOT NULL REFERENCES users(id),
                          severity_level VARCHAR(10) NOT NULL CHECK(severity_level IN ('MILD','MODERATE','SEVERE')),
                          diagnosed_date  DATE,
                          created_at  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);