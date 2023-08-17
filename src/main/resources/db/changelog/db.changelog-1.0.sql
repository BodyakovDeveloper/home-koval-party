--liquibase formatted sql

--changeset b.koval:1
CREATE SEQUENCE IF NOT EXISTS cities_sequence START WITH 1 INCREMENT BY 25;
CREATE SEQUENCE IF NOT EXISTS countries_sequence START WITH 1 INCREMENT BY 25;
CREATE SEQUENCE IF NOT EXISTS users_sequence START WITH 1 INCREMENT BY 25;

CREATE TABLE countries
(
    id   BIGINT NOT NULL,
    name VARCHAR(255),
    logo BYTEA,
    CONSTRAINT pk_country PRIMARY KEY (id)
);

CREATE TABLE cities
(
    id         BIGINT  NOT NULL,
    name       varchar NOT NULL,
    country_id BIGINT  NOT NULL,
    CONSTRAINT pk_city PRIMARY KEY (id)
);

ALTER TABLE cities
    ADD CONSTRAINT FK_CITIES_ON_COUNTRY FOREIGN KEY (country_id) REFERENCES countries (id);

CREATE TABLE users
(
    id       BIGINT NOT NULL,
    username VARCHAR(255),
    password VARCHAR(255),
    role     VARCHAR(255),
    CONSTRAINT pk_users PRIMARY KEY (id)
);

ALTER TABLE users
    ADD CONSTRAINT uc_users_username UNIQUE (username);