CREATE TABLE `vote` (
	`voterCardNumber` VARCHAR(50) NULL DEFAULT NULL,
	`candidateGroup` VARCHAR(50) NULL DEFAULT NULL
);

CREATE TABLE `voter_register` (
	`firstName` VARCHAR(50) NULL,
	`lastName` VARCHAR(50) NULL DEFAULT NULL,
	`voterCardNumber` VARCHAR(50) NULL DEFAULT NULL,
	`DateOfBirth` VARCHAR(50) NULL DEFAULT NULL,
	`contact` VARCHAR(50) NULL DEFAULT NULL,
	`email` VARCHAR(50) NULL DEFAULT NULL,
	PRIMARY KEY (`voterCardNumber`)
);

CREATE TABLE `otp` (
	`voterCardNumber` VARCHAR(50) NULL DEFAULT NULL,
	`otp` VARCHAR(50) NULL DEFAULT NULL
);

CREATE TABLE `temp_voter_card` (
	`voterCardNumber` VARCHAR(50) NULL DEFAULT NULL
);
CREATE TABLE `admin_login` (
	`userName` VARCHAR(50) NOT NULL,
	`password` VARCHAR(50) NULL DEFAULT NULL,
);


