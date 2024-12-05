CREATE TABLE IF NOT EXISTS purchase (
    id INT AUTO_INCREMENT PRIMARY KEY,
    product varchar(50) NOT NULL,
    price double NOT NULL
);

CREATE TABLE IF NOT EXISTS account (
    id INT not null AUTO_INCREMENT PRIMARY KEY,
    name varchar(50) NOT NULL,
    amount double NOT NULL
);