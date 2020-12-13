SELECT NAME,movie, year FROM movies 
WHERE YEAR < 2017 ORDER by YEAR, name

SELECT movie, NAME, YEAR FROM movies
WHERE YEAR = (SELECT MIN(YEAR) FROM movies)

SELECT distinct movie, YEAR FROM movies
WHERE YEAR = (SELECT MIN(YEAR) FROM movies)

SELECT NAME, movie, year FROM movies WHERE movie IN
(SELECT movie FROM movies WHERE NAME='박해일') AND NAME !='박해일'

SELECT movie FROM movies WHERE movie IN
(SELECT movie FROM movies WHERE NAME='송강호') AND NAME='박희순'

INSERT INTO movies(num, NAME, movie) VALUES(31, '조진웅', "암살")

TRUNCATE TABLE exam

DROP TABLE exammovies