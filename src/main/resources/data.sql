

merge INTO persons (person_id, first_name, last_name, mail, sex, birthdate) VALUES
  (1, 'Wes', 'Bos', 'wes.bos@mail.com', 'm', '2020-06-10 00:00:00.00');

merge INTO hobbies (hobbie_id, name) VALUES
  (1, 'Coding'),
  (2, 'Videogames'),
  (3, 'Reading'),
  (4, 'Pretending to be a plant')
  ;

-- insert into persons_hobbies (person_id, hobbie_id) VALUES
--   (1,1)
--   ;