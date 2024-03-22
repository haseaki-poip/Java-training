CREATE TABLE IF NOT EXISTS school (
    id INT AUTO_INCREMENT,
    name varchar(50),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS student (
    id INT AUTO_INCREMENT,
    name varchar(50),
    school_id INT,
    PRIMARY KEY (id),
    FOREIGN KEY (school_id) REFERENCES school (id)
);