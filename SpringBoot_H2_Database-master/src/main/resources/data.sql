INSERT INTO `vote` (`voterCardNumber`, `candidateGroup`) VALUES ('34531', 'Peter Parker');
INSERT INTO `vote` (`voterCardNumber`, `candidateGroup`) VALUES ('33453', 'Ram Prakash');
INSERT INTO `vote` (`voterCardNumber`, `candidateGroup`) VALUES ('34253', 'Tenzin Sonam');
INSERT INTO `vote` (`voterCardNumber`, `candidateGroup`) VALUES ('34513', 'Ram Prakash');
INSERT INTO `vote` (`voterCardNumber`, `candidateGroup`) VALUES ('34534', 'Ram Prakash');



INSERT INTO `voter_register` (`firstName`, `lastName`, `voterCardNumber`,DateOfBirth,contact,email) VALUES ('Tenzin', 'Dawa', 'tendawa123','04/05/1992','8408064330','tnzngdw@gmail.com');
INSERT INTO `voter_register` (`firstName`, `lastName`, `voterCardNumber`,DateOfBirth,contact,email) VALUES ('Tenzin', 'Dolma', 'tendol23','04/05/1992','8408064331','tnzdw@gmail.com');

INSERT INTO `admin_login` (`userName`, `password`) VALUES ('admin', 'password');

INSERT INTO `otp` (`voterCardNumber`, `otp`) VALUES ('tendawa123', '6789');

INSERT INTO `temp_voter_card` (`voterCardNumber`) VALUES ('tendawa123');