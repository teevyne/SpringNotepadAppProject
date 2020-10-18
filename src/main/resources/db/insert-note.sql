SET FOREIGN_KEY_CHECKS = 0;

TRUNCATE TABLE note;
ALTER TABLE note CHANGE `id` `id` INT(10)AUTO_INCREMENT;

INSERT INTO note(`id`, `title`, `body`)
VALUES(1, 'Header', 'This is the header. A shepherd'),
(2, 'Body', 'We can call this the body. A winner'),
(3, 'Footer', 'This can play the role of the defender');

SET FOREIGN_KEY_CHECKS = 1;