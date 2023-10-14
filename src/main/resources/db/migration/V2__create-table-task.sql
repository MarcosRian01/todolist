CREATE TABLE tb_task (
    id serial PRIMARY KEY,
    description varchar,
    title varchar NOT NULL,
    start_at time without time zone,
    end_at time with time zone,
    priority varchar(15),
    id_user BIGINT,
    created_at time with time zone
);