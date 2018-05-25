-- IMPORTANT:
-- Please use root accout to excute the "create_db_user" before setting up the database;

-- Create database
CREATE DATABASE IF NOT EXISTS test1;

-- Use database
USE test1;


CREATE TABLE IF NOT EXISTS Employee(
Name    	VARCHAR(60)  NOT NULL PRIMARY KEY,
Times       INTEGER(8)   NOT NULL,
Level       VARCHAR(5)	 NOT NULL,
Proficiency  INTEGER(8)   NOT NULL,
MonM        VARCHAR(5)	 NOT NULL,
MonN        VARCHAR(5)	 NOT NULL,
WesM        VARCHAR(5)	 NOT NULL,
WesN        VARCHAR(5)	 NOT NULL,
TusM        VARCHAR(5)	 NOT NULL,
TusN        VARCHAR(5)	 NOT NULL,
FriM        VARCHAR(5)	 NOT NULL,
FriN        VARCHAR(5)	 NOT NULL,
SatM        VARCHAR(5)	 NOT NULL,
SatN        VARCHAR(5)	 NOT NULL,
SunM        VARCHAR(5)	 NOT NULL,
SunN        VARCHAR(5)	 NOT NULL
);

CREATE TABLE IF NOT EXISTS Work_Num(
Id          INTEGER(8)  NOT NULL PRIMARY KEY,
Day         VARCHAR(60) NOT NULL, 
Morning     INTEGER(8)   NOT NULL,
Night       INTEGER(8)   NOT NULL
);

INSERT INTO Work_Num VALUES(1,'Mon',6,6);
INSERT INTO Work_Num VALUES(2,'Wed',6,6);
INSERT INTO Work_Num VALUES(3,'Thu',6,6);
INSERT INTO Work_Num VALUES(4,'Fri',6,8);
INSERT INTO Work_Num VALUES(5,'Sat',8,8);
INSERT INTO Work_Num VALUES(6,'Sun',8,8);


INSERT INTO Employee VALUES('Hugh','6','D',60,'N','Y','N','Y','N','Y','N','Y','Y','Y','Y','Y');
INSERT INTO Employee VALUES('Faye','10','S',100,'Y','Y','Y','Y','Y','Y','Y','Y','Y','Y','Y','Y');
INSERT INTO Employee VALUES('Jayden','5','D',40,'Y','Y','Y','Y','Y','Y','Y','Y','Y','Y','Y','Y');
INSERT INTO Employee VALUES('Luyu','5','D',40,'Y','Y','Y','Y','N','N','N','Y','N','N','Y','Y');
INSERT INTO Employee VALUES('Michelle','10','A',100,'Y','Y','Y','Y','Y','Y','Y','Y','Y','Y','Y','Y');
INSERT INTO Employee VALUES('Ya-shin','8','C',80,'Y','Y','N','N','Y','Y','Y','Y','Y','Y','Y','Y');
INSERT INTO Employee VALUES('Sherry','8','B',80,'Y','Y','Y','Y','N','N','Y','Y','N','N','Y','Y');
INSERT INTO Employee VALUES('Regina','5','D',60,'N','N','Y','N','Y','N','N','N','Y','Y','Y','Y');
INSERT INTO Employee VALUES('Tyna','4','C',80,'N','N','N','N','N','N','N','N','Y','Y','Y','Y');
