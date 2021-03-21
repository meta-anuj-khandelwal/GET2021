
CREATE TABLE district_state (
district_id varchar(10),
district varchar(20),
state varchar(20),
PRIMARY KEY (district_id)
); 


CREATE TABLE zip_city (
pincode VARCHAR(10),
city VARCHAR (40),
district_id varchar(10),
PRIMARY KEY (pincode),
FOREIGN KEY (district_id) REFERENCES district_state(district_id)
); 



INSERT INTO district_state values ('d1','alwar','rajasthan');
INSERT INTO district_state values ('d2','jaipur','rajasthan');
INSERT INTO district_state values ('d3','ajmer','rajasthan');
INSERT INTO district_state values ('d4','agra','uttar pardesh');
INSERT INTO district_state values ('d5','bhopal','madhay pradesh');


INSERT INTO zip_city values ('301001', 'alwar city','d1');
INSERT INTO zip_city values ('302013', 'akhepura','d2');
INSERT INTO zip_city values ('302015', 'air port jaipur','d2');
INSERT INTO zip_city values ('305001', 'ajmer city','d3');
INSERT INTO zip_city values ('282003', 'agra fort','d4');
INSERT INTO zip_city values ('462003', 'MANIT bhopal','d5');


# query for that returns a Resultset containing Zip Code, City Names and States ordered by State Name and City Name.


SELECT zip_city.pincode,zip_city.city,district_state.district,district_state.state FROM zip_city

INNER JOIN district_state ON zip_city.district_id=district_state.district_id

ORDER BY district_state.state , district_state.district;