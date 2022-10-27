
USE `customer_managment`;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
	`user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) NOT NULL,
      `email` char(68) NOT NULL,
  `password` char(68) NOT NULL,
    `name` char(68) NOT NULL,
  `last_name` char(68)  DEFAULT '' NOT NULL,
  `active` tinyint(1) NOT NULL ,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--
-- NOTE: The passwords are encrypted using BCrypt
--
--
-- Default passwords here are: fun123
--

INSERT INTO `users` 
VALUES 
(1,'litsakis','litsakis@outlook.com','{bcrypt}$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K','Alexandros','Litsakis',1);


--
-- Table structure for table `authorities`
--

DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities` (
	`role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(50) NOT NULL,
	PRIMARY KEY (`role_id`)
  
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `authorities`
--

INSERT INTO `authorities` 
VALUES 
('1','ADMIN')


