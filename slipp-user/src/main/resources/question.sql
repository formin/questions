DROP TABLE IF EXISTS QUESTION;

CREATE TABLE QUESTION ( 
	idx          	INTEGER  		NOT NULL 	auto_increment 	PRIMARY KEY,
	userId			VARCHAR(12)		NOT NULL,
	title			VARCHAR(20)		NOT NULL,
	contents		VARCHAR(255),	
	insertdates		VARCHAR(16),		
	updatedates		VARCHAR(16),			
	plaintags		VARCHAR(255),
  	
	PRIMARY KEY               (idx)
);
