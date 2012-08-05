/*Create database if not exist*/
create DATABASE durban;

use durban;
create TABLE member(
idmember INT NOT NULL AUTO_INCREMENT, 
firstname VARCHAR(55) NOT NULL,
lastname VARCHAR(55) NOT NULL,
PRIMARY KEY(idmember)
);

