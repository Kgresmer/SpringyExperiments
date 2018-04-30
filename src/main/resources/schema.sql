create table IF NOT EXISTS `message`
(
  `id` INTEGER PRIMARY KEY AUTO_INCREMENT,
  `from` VARCHAR(255) not NULL,
  `text` VARCHAR(1000) not NULL,
  `time` DATETIME not NULL,
);