CREATE TABLE `movies_2` (
	`num` INT(11) NOT NULL,
	`name` VARCHAR(20) NOT NULL COLLATE 'utf8mb4_general_ci',
	`age` INT(11) NULL DEFAULT NULL,
	`movie` VARCHAR(50) NOT NULL COLLATE 'utf8mb4_general_ci',
	`comment` TEXT(65535) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`year` YEAR NULL DEFAULT NULL,
	PRIMARY KEY (`num`) USING BTREE
)
COMMENT='영화 데이터베이스 연습'
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;
