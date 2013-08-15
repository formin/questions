DROP TABLE IF EXISTS ANSWER;

CREATE TABLE ANSWER ( 
	idx          	INTEGER  		NOT NULL 	auto_increment 	PRIMARY KEY,
	qnaidx			INTEGER			NOT NULL,
    userId			VARCHAR(20)		NOT NULL,
    contents		VARCHAR(255)	NOT NULL,
    insertdates		VARCHAR(16), 
  	
	PRIMARY KEY               (idx)
);