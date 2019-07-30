use dps;

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(24) NOT NULL,
  `password` varchar(24) NOT NULL,
  `fullName` varchar(96) NOT NULL,
  `email` varchar(48) NOT NULL,
  `updateByEmail` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO dps.user (username, password, fullName, email, updateByEmail) VALUES ('hsh', '02042018', '韩少华', 'hshua24@gmail.com', 0);
INSERT INTO dps.user (username, password, fullName, email, updateByEmail) VALUES ('steve', '22222', '乔布斯', 'steve@apple.com', 0);