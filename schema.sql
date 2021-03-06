DROP DATABASE IF EXISTS springdemo;

CREATE DATABASE springdemo;

USE springdemo;

CREATE TABLE student (
  ID VARCHAR(30) NOT NULL PRIMARY KEY,
  FULL_NAME VARCHAR(50),
  DAY_OF_BIRTH DATE
);

INSERT INTO student (ID, FULL_NAME, DAY_OF_BIRTH) VALUES ('st1', 'Nguyen Thanh Tai', '1993-05-24');
INSERT INTO student (ID, FULL_NAME, DAY_OF_BIRTH) VALUES ('st2', 'Nguyen Van Linh', '1994-02-10');
INSERT INTO student (ID, FULL_NAME, DAY_OF_BIRTH) VALUES ('st3', 'Pham Phu Quoc', '1996-10-24');
INSERT INTO student (ID, FULL_NAME, DAY_OF_BIRTH) VALUES ('st4', 'Cao Minh Tri', '1997-03-24');
INSERT INTO student (ID, FULL_NAME, DAY_OF_BIRTH) VALUES ('st5', 'Nguyen Thanh Le', '1990-01-01');
