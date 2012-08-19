/*Create database if not exist*/
create DATABASE IF NOT EXISTS durban;

/* Create member table */
use durban;
create TABLE IF NOT EXISTS member(
idmember INT NOT NULL AUTO_INCREMENT, 
firstname VARCHAR(55) NOT NULL,
lastname VARCHAR(55) NOT NULL,
PRIMARY KEY(idmember)
);

ALTER TABLE member 
ADD COLUMN  phonenumber VARCHAR(20) NOT NULL;

/*Create group table */
create TABLE IF NOT EXISTS club(
idgroup INT NOT NULL AUTO_INCREMENT,
groupname VARCHAR(55) NOT NULL,
PRIMARY KEY(idgroup)
);

