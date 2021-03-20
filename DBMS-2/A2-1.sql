
#Solution 1.A
create database StoreFront ;


CREATE TABLE user (
user_id varchar(10) NOT NULL ,
firstname varchar(50),
lastname varchar(50),
email varchar(50) NOT NULL UNIQUE,
mobileno varchar(12),
password varchar(20),
role varchar(10),  
PRIMARY KEY (user_id)
);


CREATE TABLE address(
address_id varchar(10) ,
user_id varchar(10),
house_number varchar(10),
area varchar(50),
city varchar(20),
pincode varchar(10),
state varchar(20),
country varchar(20),
PRIMARY KEY (address_id),
FOREIGN KEY (user_id) REFERENCES user(user_id)
);


CREATE TABLE product (
product_id varchar(10) NOT NULL ,
product_name varchar(50),
price numeric,
quantity integer,
addition_date datetime,
description varchar(1000),
status varchar(3),
PRIMARY KEY (product_id)
);

CREATE TABLE product_image (
image_id varchar(10) NOT NULL ,
product_id varchar(10),
image_address varchar(1000), 
PRIMARY KEY (image_id),
FOREIGN KEY (product_id) REFERENCES product(product_id)
);

CREATE TABLE product_category (
category_id varchar(10) NOT NULL ,
category_title varchar(50),
parent_category_id varchar(10), 
PRIMARY KEY (category_id),
FOREIGN KEY (parent_category_id) REFERENCES product_category(category_id)
);

CREATE TABLE product_category_mapper (
product_id varchar(10),
category_id varchar(10),
PRIMARY KEY (product_id,category_id),
FOREIGN KEY (product_id) REFERENCES product(product_id),
FOREIGN KEY (category_id) REFERENCES product_category(category_id)
);

CREATE TABLE orders (
order_id varchar(10) NOT NULL ,
user_id varchar(10) NOT NULL ,
order_date datetime,
order_status varchar(20),
amount numeric,
PRIMARY KEY (order_id),
FOREIGN KEY (user_id) REFERENCES user(user_id)
);

CREATE TABLE orders_details (
order_id varchar(10) NOT NULL ,
product_id varchar(10) NOT NULL ,
order_status varchar(20),
PRIMARY KEY (order_id,product_id),
FOREIGN KEY (order_id) REFERENCES orders(order_id),
FOREIGN KEY (product_id) REFERENCES product(product_id)
);

#Solution 1.B
show tables;


#Solution 1.C
set foreign_key_checks =0;
drop table product;
set foreign_key_checks =1;

CREATE TABLE product (
product_id varchar(10) NOT NULL ,
product_name varchar(50),
price numeric,
quantity integer,
addition_date datetime,
description varchar(1000),
status varchar(3),
PRIMARY KEY (product_id)
);






