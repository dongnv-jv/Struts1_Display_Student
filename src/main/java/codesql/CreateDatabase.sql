CREATE DATABASE `student_control_struts1` ,

CREATE TABLE `user` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(50) NOT NULL COLLATE 'utf8mb4_general_ci',
	`password` VARCHAR(50) NOT NULL COLLATE 'utf8mb4_general_ci',
	PRIMARY KEY (`id`) USING BTREE,
	UNIQUE INDEX `name` (`name`) USING BTREE
)
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=6,

CREATE TABLE `student` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`idst` VARCHAR(50) NOT NULL COLLATE 'utf8mb4_general_ci',
	`name` VARCHAR(50) NOT NULL COLLATE 'utf8mb4_general_ci',
	`dayofbirth` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`gpa` DOUBLE NULL DEFAULT NULL,
	`year` INT(11) NOT NULL,
	`password` VARCHAR(50) NULL DEFAULT '0000' COLLATE 'utf8mb4_general_ci',
	PRIMARY KEY (`id`) USING BTREE,
	UNIQUE INDEX `idst` (`idst`) USING BTREE
)
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=7
;