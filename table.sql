CREATE TABLE IF NOT EXISTS users (
	id int(50) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(20) NOT NULL,
	email VARCHAR(100) NOT NULL,
	age INT NOT NULL,
	UNIQUE KEY unique_email (email))
ENGINE=InnoDB DEFAULT CHARSET=utf8