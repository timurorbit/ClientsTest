DROP TABLE IF EXISTS clients;

DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START WITH 100000;

CREATE TABLE clients
(
    id              INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    firstName       VARCHAR   NOT NULL,
    lastName        VARCHAR   NOT NULL,
    date_time       TIMESTAMP NOT NULL,
    status          VARCHAR   NOT NULL,
    satisfaction    VARCHAR   NOT NULL,
    address         VARCHAR   NOT NULL,
    email           VARCHAR   NOT NULL,
    telephoneNumber VARCHAR   NOT NULL,
    image          bytea
);