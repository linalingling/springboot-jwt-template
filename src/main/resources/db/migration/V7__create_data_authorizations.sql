CREATE TABLE data_authorizations(
                                    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                                    user_id BIGINT NOT NULL REFERENCES users(id),
                                    target_user_id BIGINT NOT NULL REFERENCES users(id),
                                    scope VARCHAR(50) NOT NULL CHECK(scope IN('MEDICAL','LIFESTYLE','COACH')),
                                    revoked_at TIMESTAMP,
                                    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE UNIQUE INDEX idx_active_authorization
    ON data_authorizations (user_id, target_user_id, scope)
    WHERE revoked_at IS NULL;