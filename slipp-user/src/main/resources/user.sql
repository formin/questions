DROP TABLE IF EXISTS USERS;

CREATE TABLE USERS ( 
	userId          varchar(12)		NOT NULL, 
	password		varchar(12)		NOT NULL,
	name			varchar(20)		NOT NULL,
	email			varchar(50),	
  	
	PRIMARY KEY               (userId)
);

INSERT INTO USERS VALUES('admin', 'password', '자바지기', 'admin@javajigi.net');
INSERT INTO USERS VALUES('formin', 'self6677', '김경민', 'formin@sds.co.kr');

DROP TABLE IF EXISTS AUDIT;

CREATE TABLE AUDIT (
	id				INTEGER 		NOT NULL 	IDENTITY 	PRIMARY KEY,
	who				VARCHAR(12)		NOT NULL,
	whenn			DATE,
	resource		VARCHAR(255)	NOT NULL,
	action			VARCHAR(30)		NOT NULL
);

DROP TABLE IF EXISTS QNA;

CREATE TABLE QNA ( 
	idx          	INTEGER 		NOT NULL 	IDENTITY 	PRIMARY KEY,
	userId			VARCHAR(12)		NOT NULL,
	title			VARCHAR(20)		NOT NULL,
	contents		VARCHAR(255),	
	insertdates		DATE,		
	updatedates		DATE,			
	plaintags		DATE,
  	
	PRIMARY KEY               (idx)
);