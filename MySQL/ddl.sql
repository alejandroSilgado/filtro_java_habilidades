CREATE DATABASE sgpzf;
USE sgpzf;

CREATE TABLE stack (
    id INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);
CREATE TABLE skill (
    id INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);
CREATE TABLE stack_skill(
    idskill INT,
    idstack INT,

    FOREIGN KEY (idskill) REFERENCES skill(id),
    FOREIGN KEY (idstack) REFERENCES stack(id)
);
CREATE TABLE gender (
    id INTEGER PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);
CREATE TABLE country (
    id INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE region (
    id INTEGER PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    idcountry INT,
    FOREIGN KEY (idcountry) REFERENCES country(id)
);

CREATE TABLE city (
    id INTEGER PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    idregion INT,

    FOREIGN KEY (idregion) REFERENCES region(id)
);
CREATE TABLE persons (
    id INTEGER PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    lastname VARCHAR(50) NOT NULL,
    idcity INT,
    address VARCHAR(50) NOT NULL,
    age INT,
    email VARCHAR(100) NOT NULL,
    idgender INT,

    FOREIGN KEY (idgender) REFERENCES gender(id),
    FOREIGN KEY (idcity) REFERENCES city(id)
);
CREATE TABLE person_skill (
    id INT PRIMARY KEY,
    registration_date DATE,
    idperson INT,
    idskill INT,
    FOREIGN KEY (idperson) REFERENCES persons(id),
    FOREIGN KEY (idskill) REFERENCES skill(id)
);

