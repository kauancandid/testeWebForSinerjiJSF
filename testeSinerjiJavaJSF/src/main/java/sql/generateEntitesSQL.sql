CREATE TABLE person (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    age DATE NOT NULL,
    sex CHAR(1) NOT NULL
);

CREATE TABLE address (
    id SERIAL PRIMARY KEY,
    person_id INT NOT NULL,
    state VARCHAR(50) NOT NULL,
    city VARCHAR(100) NOT NULL,
    public_place VARCHAR(200) NOT NULL,
    num INT NOT NULL,
    zip_code VARCHAR(10) NOT NULL,
    FOREIGN KEY (person_id) REFERENCES person(id)
);
