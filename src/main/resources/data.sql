INSERT INTO user(email, password, name, create_date)
VALUES ('mmm@test.com', 'erwewrwe', 'frank', curdate()),
('mmm@test33123.com', 'qwerty', 'Sam', curdate()),
('mmm@test33123.com', 'qwerty', 'Mike', curdate()),
('mmm@test33123.com', 'qwerty', 'Lol', curdate()),
('mmm@test33123.com', 'qwerty', 'CAt', curdate()),
('mmm@test33123.com', 'qwerty', 'wqerty', curdate()),
('mmm@test33123.com', 'qwerty', 'John', curdate()),
('mmm@test123.com', 'qweertuu', 'Scofield', curdate());

insert into quote(message, rating, create_date, user_id)
values ('message1', 21, curdate(), 1),
       ('message2', 200, curdate(), 2),
       ('message2', 1234, curdate(), 1),
       ('message2', 22, curdate(), 3),
       ('message2', 11, curdate(), 5),
       ('message2', 0, curdate(), 7),
       ('message2', 77, curdate(), 7),
       ('message2', 2, curdate(), 8),
       ('message2', 55, curdate(), 1),
       ('message2', 2, curdate(), 1),
       ('message2', 5, curdate(), 1),
       ('message2', 5, curdate(), 1),
       ('message2', 5, curdate(), 1),
       ('message3', 7, curdate(), 1);