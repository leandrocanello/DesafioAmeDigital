CREATE TABLE planet(
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    climate VARCHAR(100),
    ground VARCHAR(100),
    apparition INTEGER
);