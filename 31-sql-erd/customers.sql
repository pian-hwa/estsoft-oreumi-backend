-- SQLite
CREATE TABLE customers (
    id          BIGINT      NOT NULL,
    name        VARCHAR(20) NOT NULL,
    age         INT,
    rank        VARCHAR(10) NOT NULL,
    occupation  VARCHAR(50),
    savings     INT         DEFAULT 0,

    CONSTRAINT PK_ID PRIMARY KEY (id),
    CONSTRAINT CHECK_AGE CHECK (age >= 0)
);