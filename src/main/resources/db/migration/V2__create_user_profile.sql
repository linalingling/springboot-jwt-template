CREATE TABLE user_profile (
                              id          BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                              user_id     BIGINT NOT NULL REFERENCES users(id),
                              name        VARCHAR(100) NOT NULL,
                              birth_date  DATE NOT NULL,
                              created_at  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                              UNIQUE (user_id)
);