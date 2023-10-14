CREATE TABLE tb_users (
    id serial PRIMARY KEY,
    username varchar(100) NOT NULL,
    name varchar(30),
    password varchar(255) NOT NULL,
    created_at time without time zone
);