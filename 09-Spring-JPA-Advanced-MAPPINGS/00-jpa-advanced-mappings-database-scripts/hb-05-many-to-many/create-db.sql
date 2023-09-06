DROP SCHEMA IF EXISTS `hb-05-many-to-many`;

CREATE SCHEMA `hb-05-many-to-many`;

use `hb-05-many-to-many`;

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
  `user_id` int DEFAULT NULL,playable_character
  
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


CREATE TABLE `class` (
  `id` int NOT NULL AUTO_INCREMENT,
  `class_role` varchar(45) DEFAULT NULL,
  `class_skill` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


CREATE TABLE `playable_character-class` (
  `playable_character_id` int NOT NULL,
  `class_id` int NOT NULL,
  
  PRIMARY KEY (`playable_character_id`,`class_id`),
  
  KEY `FK_PLAYABLE_CHARACTER_idx` (`playable_character_id`),
  
  CONSTRAINT `FK_CLASS_05` FOREIGN KEY (`class_id`) 
  REFERENCES `class` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  
  CONSTRAINT `FK_PLAYABLE_CHARACTER_05` FOREIGN KEY (`playable_character_id`) 
  REFERENCES `playable_character` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;
