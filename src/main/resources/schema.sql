DROP TABLE IF EXISTS `eventsdb`;

CREATE TABLE `eventsdb` (
    `id` INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    `name` VARCHAR(50) NOT NULL,
    `description` VARCHAR(200) NOT NULL,
    `eventtype` VARCHAR(20) NOT NULL,
    `place` VARCHAR(50) NOT NULL,
    `eventdate` TIMESTAMP NOT NULL
);