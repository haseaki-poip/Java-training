CREATE TABLE IF NOT EXISTS professor (
    id INT AUTO_INCREMENT,
    name varchar(50),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS professor_info (
    id INT AUTO_INCREMENT,
    professor_id INT,
    birth_date DATE,
    gender CHAR(1),
    PRIMARY KEY (id),
    FOREIGN KEY (professor_id) REFERENCES professor (id)    
);