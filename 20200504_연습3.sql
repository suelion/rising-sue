SELECT * FROM movies LIMIT 10

SELECT movie, NAME FROM movies WHERE NAME="송강호"
OR NAME="황정민" LIMIT 3

SELECT DISTINCT name FROM movies ORDER BY NAME
//distinict 중복없이

SELECT * FROM movies ORDER BY movie DESC

SELECT movie FROM movies WHERE NAME="송강호" ORDER BY movie

ALTER TABLE movies ADD YEAR INT NULL

ALTER TABLE movies DROP COLUMN YEAR

UPDATE movies SET YEAR=2017 WHERE movie="군함도";
UPDATE movies SET YEAR=2017 WHERE movie="VIP";
UPDATE movies SET YEAR=2017 WHERE movie="남한산성";

UPDATE movies SET YEAR=2016 WHERE movie="밀정"
OR movie="곡성" OR movie="터널"

UPDATE movies SET YEAR=2013 WHERE movie="신세계";
UPDATE movies SET YEAR=2015 WHERE movie="암살";
UPDATE movies SET YEAR=2003 WHERE movie="살인의추억";
UPDATE movies SET YEAR=2019 WHERE movie="기생충";