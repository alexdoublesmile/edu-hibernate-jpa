DROP TABLE IF EXISTS spitter;

CREATE TABLE spitter (
  user_id int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  user_name varchar not null,
  user_password varchar not null,
  user_full_name varchar not null,
  user_mail varchar,
  is_update_by_email boolean
);

CREATE INDEX idx_user_id ON spitter(user_id);

INSERT INTO spitter(user_name, user_password, user_full_name, user_mail)
VALUES
       ('First Spitty', 'password', 'Dr. Spitter The First', 'firstspit@gmail.com');