DROP SCHEMA IF EXISTS `hb-04-one-to-many-uni`;

CREATE SCHEMA `hb-04-one-to-many-uni`;

use `hb-04-one-to-many-uni`;

SET FOREIGN_KEY_CHECKS = 0;

CREATE TABLE `account_details` (
  `id` int NOT NULL AUTO_INCREMENT,
  `link` varchar(128) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `account_details_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_ACCOUNT_DETAILS_idx` (`account_details_id`),
  CONSTRAINT `FK_ACCOUNT_DETAILS_idx` FOREIGN KEY (`account_details_id`) 
  REFERENCES `account_details` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


CREATE TABLE `playable_character` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(128) DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  
  PRIMARY KEY (`id`),
  
  UNIQUE KEY `UNIQUE_NAME` (`name`),
  
  KEY `FK_USER_idx` (`user_id`),
  
  CONSTRAINT `FK_USER` 
  FOREIGN KEY (`user_id`) 
  REFERENCES `user` (`id`) 
  
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;


CREATE TABLE `item` (
  `id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(256) DEFAULT NULL,
  `playable_character_id` int DEFAULT NULL,

  PRIMARY KEY (`id`),

  KEY `FK_PLAYABLE_CHARACTER_ID_idx` (`playable_character_id`),

  CONSTRAINT `FK_PLAYABLE_CHARACTER` 
  FOREIGN KEY (`playable_character_id`) 
  REFERENCES `playable_character` (`id`) 

  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


SET FOREIGN_KEY_CHECKS = 1;
