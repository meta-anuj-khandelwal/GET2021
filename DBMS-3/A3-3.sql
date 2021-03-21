#Display Shopper’s information along with number of orders he/she placed during last 30 days.

SELECT  user.user_id  ,user.firstname ,user.lastname ,user.email ,user.mobileno, COUNT(orders.order_id )   FROM user 

INNER JOIN orders ON user.user_id = orders.user_id

WHERE DATEDIFF(NOW(),orders.order_date) <= 30

GROUP BY (user.user_id);

#Display the top 10 Shoppers who generated maximum number of revenue in last 30 days.

SELECT  user.user_id  ,user.firstname ,user.lastname ,user.email ,user.mobileno   FROM user 

INNER JOIN orders ON user.user_id = orders.user_id

WHERE DATEDIFF(NOW(),orders.order_date) <= 30

GROUP BY (user.user_id) ORDER BY orders.amount DESC LIMIT 10;

#Display top 20 Products which are ordered most in last 60 days along with numbers.

SELECT  product.product_id,product.product_name ,count(orders.order_id)FROM ((product 

INNER JOIN orders_details ON product.product_id = orders_details.product_id )

INNER JOIN orders ON orders.order_id = orders_details.order_id)

WHERE DATEDIFF(NOW(),orders.order_date) <= 60

GROUP BY (product.product_id) ORDER BY  count(orders.order_id) DESC LIMIT 20;


#Display Monthly sales revenue of the StoreFront for last 6 months. It should display each month’s sale.

SELECT SUM(orders.amount) AS revenue ,

PERIOD_DIFF(DATE_FORMAT(NOW(),"%Y%m"),DATE_FORMAT(orders.order_date,"%Y%m")) AS MONTH

FROM orders 

WHERE PERIOD_DIFF(DATE_FORMAT(NOW(),"%Y%m"),DATE_FORMAT(orders.order_date,"%Y%m")) <=6

GROUP BY MONTH;

#Mark the products as Inactive which are not ordered in last 90 days.


select * from product;

UPDATE product 

SET product.status = 'no'

WHERE product.product_id NOT IN (SELECT  orders_details.product_id from orders_details

INNER JOIN orders ON orders.order_id = orders_details.order_id

WHERE DATEDIFF(NOW(),orders.order_date) <= 90

GROUP BY (orders_details.product_id));


select * from product;

#Given a category search keyword, display all the Products present in this category/categories. 

SELECT product.product_id,product.product_name FROM( (product

INNER JOIN  product_category_mapper ON product_category_mapper.product_id=product.product_id)

inner join product_category ON product_category.category_id=product_category_mapper.category_id)

WHERE  product_category.category_title LIKE "tshir%";

#Display top 10 Items which were cancelled most.

SELECT  product.product_id ,product.product_name ,COUNT(orders.order_id) FROM ((orders 

INNER JOIN orders_details ON orders.order_id = orders_details.order_id )

INNER JOIN product ON orders_details.product_id = product.product_id)

WHERE orders_details.order_status = "cancelled" 

GROUP BY product.product_id

ORDER BY COUNT(orders.order_id) DESC

LIMIT 10 ;

