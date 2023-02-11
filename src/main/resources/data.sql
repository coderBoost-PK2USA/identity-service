INSERT INTO roles (id, role, created_at, updated_at)
VALUES (1, 'ADMIN', '2023-02-07 18:05:54.074477 +00:00', '2023-02-07 18:05:54.074477 +00:00');
INSERT INTO roles (id, role, created_at, updated_at)
VALUES (2, 'CUSTOMER', '2023-02-07 18:05:54.074477 +00:00', '2023-02-07 18:05:54.074477 +00:00');
INSERT INTO roles (id, role, created_at, updated_at)
VALUES (3, 'OWNER', '2023-02-07 18:05:54.074477 +00:00', '2023-02-07 18:05:54.074477 +00:00');

INSERT INTO users
(name, email, password, phone_number, user_status, role_id, updated_at, created_at)
VALUES ('Super User', 'superuser@gmail.com', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2',
        '6412337854', 'ACTIVE', 1, '2023-02-07 18:05:54.074477 +00:00',
        '2023-02-07 18:05:54.074477 +00:00'); -- Password => 123

INSERT INTO users
(name, email, password, phone_number, user_status, role_id, updated_at, created_at)
VALUES ('Customer User', 'customer@gmail.com', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2',
        '6412337878', 'ACTIVE', 2, '2023-02-07 18:05:54.074477 +00:00',
        '2023-02-07 18:05:54.074477 +00:00'); -- Password => 123

INSERT INTO users
(name, email, password, phone_number, user_status, role_id, updated_at, created_at)
VALUES ('Customer User 2', 'customer_2@gmail.com', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2',
        '6412337878', 'ACTIVE', 2, '2023-02-07 18:05:54.074477 +00:00',
        '2023-02-07 18:05:54.074477 +00:00'); -- Password => 123


INSERT INTO users
(id, name, email, password, phone_number, user_status, role_id, updated_at, created_at)
VALUES (1001, 'Owner User', 'owner@gmail.com', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2',
        '6412337348', 'ACTIVE', 3, '2023-02-07 18:05:54.074477 +00:00',
        '2023-02-07 18:05:54.074477 +00:00'); -- Password => 123

INSERT INTO users
(id, name, email, password, phone_number, user_status, role_id, updated_at, created_at)
VALUES (1002, 'Owner User 2', 'owner_2@gmail.com', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2',
        '6412337348', 'ACTIVE', 3, '2023-02-07 18:05:54.074477 +00:00',
        '2023-02-07 18:05:54.074477 +00:00'); -- Password => 123




