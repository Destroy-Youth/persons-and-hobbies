
CREATE TABLE IF NOT EXISTS persons (
  id INT AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(100) NOT NULL,
  last_name VARCHAR(100) NOT NULL,
  birthdate DATE,
  mail VARCHAR(30) NOT NULL,
  sex VARCHAR(1) NOT NULL,
  id_hobbie INT,
  FOREIGN KEY (id_hobbie) 
    REFERENCES hobbies(id)
);

CREATE TABLE IF NOT EXISTS hobbies (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(30) NOT NULL
);



merge INTO persons (id, first_name, last_name, mail, sex, id_hobbie, birthdate) VALUES
  (1, 'Wes', 'Bos', 'wes.bos@mail.com', 'm', 1, '2020-06-10 00:00:00.00');

merge INTO hobbies (id, name) VALUES
  (1, 'Coding'),
  (2, 'Videogames'),
  (3, 'Reading'),
  (4, 'Pretending to be a plant')
  ;