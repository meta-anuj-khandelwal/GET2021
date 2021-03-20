
#Solution 2.A

#insertion in user table
INSERT INTO user (user_id  ,firstname ,lastname ,email ,mobileno ,password ,role ) VALUES('1','a1','k1','a1@gmail.com','9000000001','pass','shopper'); 

INSERT INTO user (user_id  ,firstname ,lastname ,email ,mobileno ,password,role ) VALUES('2','a2','k2','a2@gmail.com','9000000002','pass','shopper'); 

INSERT INTO user (user_id  ,firstname ,lastname ,email ,mobileno ,password,role ) VALUES('3','a3','k3','a3@gmail.com','9000000003','pass','shopper'); 

INSERT INTO user (user_id  ,firstname ,lastname ,email ,mobileno ,password,role ) VALUES('4','a4','k4','a4@gmail.com','9000000004','pass','shopper'); 

INSERT INTO user (user_id  ,firstname ,lastname ,email ,mobileno ,password,role ) VALUES('5','a5','k5','a5@gmail.com','9000000005','pass','shopper'); 

INSERT INTO user (user_id  ,firstname ,lastname ,email ,mobileno ,password,role ) VALUES('6','a6','k6','a6@gmail.com','9000000006','pass','shopper'); 

INSERT INTO user (user_id  ,firstname ,lastname ,email ,mobileno ,password,role ) VALUES('7','a7','k7','a7@gmail.com','9000000007','pass','shopper'); 

INSERT INTO user (user_id  ,firstname ,lastname ,email ,mobileno ,password,role ) VALUES('8','a8','k8','a8@gmail.com','9000000008','pass','shopper'); 

INSERT INTO user (user_id  ,firstname ,lastname ,email ,mobileno ,password,role ) VALUES('9','a9','k9','a9@gmail.com','9000000009','pass','shopper'); 

INSERT INTO user (user_id  ,firstname ,lastname ,email ,mobileno ,password,role ) VALUES('99','a99','k10','a99@gmail.com','9000000099','pass','shopper'); 

INSERT INTO user (user_id  ,firstname ,lastname ,email ,mobileno ,password,role ) VALUES('0','admin','ji','admin@gmail.com','9000000000','pass','admin'); 

select * from user;

#insertion in address table
INSERT INTO  address(address_id ,user_id ,house_number ,area ,city ,pincode ,state ,country) values('a1','1','1','panchvati','alwar','301001','rajasthan','india');
INSERT INTO  address(address_id ,user_id ,house_number ,area ,city ,pincode ,state ,country) values('a2','1','2','panchvati1','alwar1','301002','rajasthan1','india1');
INSERT INTO  address(address_id ,user_id ,house_number ,area ,city ,pincode ,state ,country) values('a3','2','3','panchvati2','alwar','301003','rajasthan','india');
INSERT INTO  address(address_id ,user_id ,house_number ,area ,city ,pincode ,state ,country) values('a4','2','4','panchvati3','alwar1','301003','rajasthan1','india1');
INSERT INTO  address(address_id ,user_id ,house_number ,area ,city ,pincode ,state ,country) values('a5','3','5','panchvati4','alwar','301004','rajasthan','india');
INSERT INTO  address(address_id ,user_id ,house_number ,area ,city ,pincode ,state ,country) values('a6','3','6','panchvati5','alwar1','301004','rajasthan1','india1');
INSERT INTO  address(address_id ,user_id ,house_number ,area ,city ,pincode ,state ,country) values('a7','4','7','panchvati6','alwar','301005','rajasthan','india');
INSERT INTO  address(address_id ,user_id ,house_number ,area ,city ,pincode ,state ,country) values('a8','4','8','panchvati7','alwar1','301002','rajasthan1','india1');
INSERT INTO  address(address_id ,user_id ,house_number ,area ,city ,pincode ,state ,country) values('a9','5','9','panchvati8','alwar','301006','rajasthan','india');
INSERT INTO  address(address_id ,user_id ,house_number ,area ,city ,pincode ,state ,country) values('a10','5','10','panchvati10','alwar1','301007','rajasthan1','india1');
INSERT INTO  address(address_id ,user_id ,house_number ,area ,city ,pincode ,state ,country) values('a11','6','11','panchvati11','alwar','301008','rajasthan','india');
INSERT INTO  address(address_id ,user_id ,house_number ,area ,city ,pincode ,state ,country) values('a12','6','12','panchvati12','alwar1','301002','rajasthan1','india1');
INSERT INTO  address(address_id ,user_id ,house_number ,area ,city ,pincode ,state ,country) values('a13','7','13','panchvati13','alwar','301003','rajasthan','india');
INSERT INTO  address(address_id ,user_id ,house_number ,area ,city ,pincode ,state ,country) values('a14','8','14','panchvati14','alwar1','301007','rajasthan1','india1');
INSERT INTO  address(address_id ,user_id ,house_number ,area ,city ,pincode ,state ,country) values('a15','9','15','panchvati15','alwar','301001','rajasthan','india');
INSERT INTO  address(address_id ,user_id ,house_number ,area ,city ,pincode ,state ,country) values('a16','10','16','panchvati16','alwar1','301004','rajasthan1','india1');

select * from address;

#insertion in product table

INSERT INTO product (product_id  ,product_name ,price ,quantity ,addition_date ,description ,status ) values ('p1','product1',100,150,"2021-03-11 12:30:00",'this product is very good','yes');
INSERT INTO product (product_id  ,product_name ,price ,quantity ,addition_date ,description ,status ) values ('p2','product2',200,15,"2021-03-12 12:30:00",'this product is very good','yes');
INSERT INTO product (product_id  ,product_name ,price ,quantity ,addition_date ,description ,status ) values ('p3','product3',100,80,"2021-03-13 12:30:00",'this product is very good','yes');
INSERT INTO product (product_id  ,product_name ,price ,quantity ,addition_date ,description ,status ) values ('p4','product4',400,50,"2021-02-14 12:30:00",'this product is very good','yes');
INSERT INTO product (product_id  ,product_name ,price ,quantity ,addition_date ,description ,status ) values ('p5','product5',150,30,"2021-02-09 12:30:00",'this product is very good','yes');
INSERT INTO product (product_id  ,product_name ,price ,quantity ,addition_date ,description ,status ) values ('p6','product6',140,160,"2021-01-10 12:30:00",'this product is very good','no');
INSERT INTO product (product_id  ,product_name ,price ,quantity ,addition_date ,description ,status ) values ('p7','product7',130,190,"2021-03-05 12:30:00",'this product is very good','no');
INSERT INTO product (product_id  ,product_name ,price ,quantity ,addition_date ,description ,status ) values ('p8','product8',110,110,"2021-01-11 12:30:00",'this product is very good','yes');
INSERT INTO product (product_id  ,product_name ,price ,quantity ,addition_date ,description ,status ) values ('p9','product9',1000,103,"2021-03-18 12:30:00",'this product is very good','yes');
INSERT INTO product (product_id  ,product_name ,price ,quantity ,addition_date ,description ,status ) values ('p10','product10',1200,3,"2021-02-17 12:30:00",'this product is very good','yes');

select * from product;  



#insertion in product_image table

INSERT INTO product_image (image_id,product_id ,image_address) values("i1","p1","path1");
INSERT INTO product_image (image_id,product_id ,image_address) values("i2","p1","path2");
INSERT INTO product_image (image_id,product_id ,image_address) values("i4","p3","path4");
INSERT INTO product_image (image_id,product_id ,image_address) values("i5","p3","path5");
INSERT INTO product_image (image_id,product_id ,image_address) values("i6","p4","path6");
INSERT INTO product_image (image_id,product_id ,image_address) values("i7","p5","path7");
INSERT INTO product_image (image_id,product_id ,image_address) values("i8","p6","path8");
INSERT INTO product_image (image_id,product_id ,image_address) values("i9","p7","path9");
INSERT INTO product_image (image_id,product_id ,image_address) values("i10","p8","path10");
INSERT INTO product_image (image_id,product_id ,image_address) values("i11","p9","path11");
INSERT INTO product_image (image_id,product_id ,image_address) values("i12","p9","path12");
INSERT INTO product_image (image_id,product_id ,image_address) values("i13","p9","path13");
INSERT INTO product_image (image_id,product_id ,image_address) values("i14","p9","path14");


select * from product_image;  


#insertion in product_category table
INSERT INTO product_category (category_id,category_title) values('c1','mobile');
INSERT INTO product_category (category_id,category_title) values('c2','cloths');
INSERT INTO product_category (category_id,category_title) values('c3','furniture');
INSERT INTO product_category (category_id,category_title,parent_category_id) values('c4','smartphone','c1');
INSERT INTO product_category (category_id,category_title,parent_category_id) values('c5','laptop','c1');
INSERT INTO product_category (category_id,category_title,parent_category_id) values('c6','tablet','c1');
INSERT INTO product_category (category_id,category_title,parent_category_id) values('c7','tshirt','c2');
INSERT INTO product_category (category_id,category_title,parent_category_id) values('c8','pant','c2');
INSERT INTO product_category (category_id,category_title,parent_category_id) values('c9','shirt','c2');
INSERT INTO product_category (category_id,category_title,parent_category_id) values('c10','desk','c3');
INSERT INTO product_category (category_id,category_title,parent_category_id) values('c11','table','c3');
INSERT INTO product_category (category_id,category_title,parent_category_id) values('c12','chair','c3');


select * from product_category;  

#insertion in product_category_mapper table

use storefront;
INSERT INTO product_category_mapper (product_id ,category_id) values('p1','c4');
INSERT INTO product_category_mapper (product_id ,category_id) values('p1','c5');
INSERT INTO product_category_mapper (product_id ,category_id) values('p2','c6');
INSERT INTO product_category_mapper (product_id ,category_id) values('p3','c7');
INSERT INTO product_category_mapper (product_id ,category_id) values('p4','c7');
INSERT INTO product_category_mapper (product_id ,category_id) values('p5','c8');
INSERT INTO product_category_mapper (product_id ,category_id) values('p6','c9');
INSERT INTO product_category_mapper (product_id ,category_id) values('p6','c10');
INSERT INTO product_category_mapper (product_id ,category_id) values('p7','c1');
INSERT INTO product_category_mapper (product_id ,category_id) values('p7','c3');
INSERT INTO product_category_mapper (product_id ,category_id) values('p7','c4');
INSERT INTO product_category_mapper (product_id ,category_id) values('p8','c4');
INSERT INTO product_category_mapper (product_id ,category_id) values('p9','c5');
INSERT INTO product_category_mapper (product_id ,category_id) values('p10','c6');
INSERT INTO product_category_mapper (product_id ,category_id) values('p10','c7');

select * from product_category_mapper;


#insertion in orders table
INSERT INTO orders (order_id ,user_id  ,order_date ,order_status ,amount) values ("o1","1","2021-03-11 12:30:00","delivered",500);
INSERT INTO orders (order_id ,user_id  ,order_date ,order_status ,amount) values ("o2","2","2021-03-14 12:30:00","pending",300);
INSERT INTO orders (order_id ,user_id  ,order_date ,order_status ,amount) values ("o3","3","2021-03-13 12:30:00","pending",600);
INSERT INTO orders (order_id ,user_id  ,order_date ,order_status ,amount) values ("o4","4","2021-03-14 12:30:00","cancelled",340);
INSERT INTO orders (order_id ,user_id  ,order_date ,order_status ,amount) values ("o5","5","2021-03-16 12:30:00","cancelled",550);
INSERT INTO orders (order_id ,user_id  ,order_date ,order_status ,amount) values ("o6","6","2021-03-17 12:30:00","delivered",310);
INSERT INTO orders (order_id ,user_id  ,order_date ,order_status ,amount) values ("o7","7","2021-03-02 12:30:00","processing",100);
INSERT INTO orders (order_id ,user_id  ,order_date ,order_status ,amount) values ("o8","7","2021-03-03 12:30:00","processing",210);
INSERT INTO orders (order_id ,user_id  ,order_date ,order_status ,amount) values ("o9","8","2021-02-03 12:30:00","shipped",110);

select * from orders;



#insertion in orders_details table
INSERT INTO orders_details (order_id  ,product_id  ,order_status)values ('o1','p1','delivered');
INSERT INTO orders_details (order_id  ,product_id  ,order_status)values ('o1','p2','delivered');
INSERT INTO orders_details (order_id  ,product_id  ,order_status)values ('o1','p3','delivered');
INSERT INTO orders_details (order_id  ,product_id  ,order_status)values ('o2','p1','pending');
INSERT INTO orders_details (order_id  ,product_id  ,order_status)values ('o2','p5','pending');
INSERT INTO orders_details (order_id  ,product_id  ,order_status)values ('o2','p2','shipped');
INSERT INTO orders_details (order_id  ,product_id  ,order_status)values ('o3','p2','pending');
INSERT INTO orders_details (order_id  ,product_id  ,order_status)values ('o4','p8','cancelled');
INSERT INTO orders_details (order_id  ,product_id  ,order_status)values ('o4','p2','cancelled');
INSERT INTO orders_details (order_id  ,product_id  ,order_status)values ('o5','p3','cancelled');
INSERT INTO orders_details (order_id  ,product_id  ,order_status)values ('o5','p7','cancelled');
INSERT INTO orders_details (order_id  ,product_id  ,order_status)values ('o5','p2','cancelled');
INSERT INTO orders_details (order_id  ,product_id  ,order_status)values ('o6','p3','delivered');
INSERT INTO orders_details (order_id  ,product_id  ,order_status)values ('o7','p3','pending');
INSERT INTO orders_details (order_id  ,product_id  ,order_status)values ('o7','p1','pending');
INSERT INTO orders_details (order_id  ,product_id  ,order_status)values ('o8','p3','processing');
INSERT INTO orders_details (order_id  ,product_id  ,order_status)values ('o9','p6','shipped');
INSERT INTO orders_details (order_id  ,product_id  ,order_status)values ('o9','p7','shipped');

select * from orders_details;

