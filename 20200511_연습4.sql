
SELECT distinct movie, YEAR FROM movies WHERE YEAR>=2015 
AND YEAR<=2017 ORDER BY YEAR, movie

UPDATE movies SET YEAR=2019 WHERE movie="기생충"

SELECT MAX(YEAR) FROM movies

SELECT MIN(YEAR) FROM movies

SELECT count(NAME) FROM movies

SELECT count(DISTINCT(NAME)) FROM movies

INSERT INTO exam VALUES(1, "국어", 95);
INSERT INTO exam VALUES(2, "영어", 92);
INSERT INTO exam VALUES(3, "수학", 99);

SELECT SUM(score) FROM exam
SELECT AVG(score) FROM exam
SELECT SUM(score)/3 FROM exam
SELECT SUM(score)/COUNT(subject) FROM exam

SELECT distinct NAME FROM movies WHERE NAME LIKE "박%" 

SELECT distinct NAME FROM movies WHERE NAME LIKE "%민"

SELECT DISTINCT NAME FROM movies WHERE NAME LIKE "%정%"

SELECT distinct NAME, movie, year FROM movies WHERE YEAR<2017 ORDER BY NAME, year

SELECT distinct NAME, movie, year FROM movies WHERE YEAR<2017 ORDER BY NAME, movie

