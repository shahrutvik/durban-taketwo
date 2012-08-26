/*Create database if not exist*/
create DATABASE IF NOT EXISTS durban;

/* Create member table */
use durban;
create TABLE IF NOT EXISTS member(
idmember INT NOT NULL AUTO_INCREMENT, 
firstname VARCHAR(55) NOT NULL,
lastname VARCHAR(55) NOT NULL,
phonenumber VARCHAR(20) NOT NULL,
PRIMARY KEY(idmember)
);



/*Create group table */
create TABLE IF NOT EXISTS club(
idclub INT NOT NULL AUTO_INCREMENT,
name VARCHAR(55) NOT NULL,
PRIMARY KEY(idclub)
);

/*Create member club relationship table */
create TABLE IF NOT EXISTS memberclubs(
idmember INT,
idclub INT,
FOREIGN KEY(idmember) REFERENCES member(idmember),
FOREIGN KEY(idclub) REFERENCES club(idclub)
);


