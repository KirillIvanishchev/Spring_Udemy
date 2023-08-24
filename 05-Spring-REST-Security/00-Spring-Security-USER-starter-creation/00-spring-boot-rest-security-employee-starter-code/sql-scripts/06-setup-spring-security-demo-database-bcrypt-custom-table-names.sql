USE `employee_directory`;

DROP TABLE IF EXISTS `roles`;
DROP TABLE IF EXISTS `members`;

--
-- Table structure for table `members`
--

CREATE TABLE `members` (
  `user_id` varchar(50) NOT NULL,
  `pw` char(68) NOT NULL,
  `active` tinyint NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `members`
--
-- NOTE: The passwords are encrypted using BCrypt
--
-- A generation tool is avail at: https://www.luv2code.com/generate-bcrypt-password
--
-- Default passwords here are: fun123
--

INSERT INTO `members`
VALUES
('Kirill','{bcrypt}$2a$10$.z4UlZ3lRtBfyQdba17/wOiIfrRwpNxQ0sg4Fb1xz88oXdTu4/hqa',1),
('Kostia','{bcrypt}$2a$10$.z4UlZ3lRtBfyQdba17/wOiIfrRwpNxQ0sg4Fb1xz88oXdTu4/hqa',1),
('Igor','{bcrypt}$2a$10$.z4UlZ3lRtBfyQdba17/wOiIfrRwpNxQ0sg4Fb1xz88oXdTu4/hqa',1);


--
-- Table structure for table `authorities`
--

CREATE TABLE `roles` (
  `user_id` varchar(50) NOT NULL,
  `role` varchar(50) NOT NULL,
  UNIQUE KEY `authorities5_idx_1` (`user_id`,`role`),
  CONSTRAINT `authorities5_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `members` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `roles`
--

INSERT INTO `roles`
VALUES
('Kirill','ROLE_GameDesigner'),
('Kostia','ROLE_GameDesigner'),
('Kostia','ROLE_GameDeveloper'),
('Igor','ROLE_GameDesigner'),
('Igor','ROLE_GameDeveloper'),
('Igor','ROLE_NetDeveloper');
