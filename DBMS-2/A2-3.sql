#1. Display Recent 50 Orders placed (Id, Order Date, Order Total).

SELECT order_id ,order_date ,amount FROM orders ORDER BY order_date DESC LIMIT 50; 

#2. Display 10 most expensive Orders.

SELECT order_id ,order_date ,amount FROM orders ORDER BY amount DESC LIMIT 10; 

#3. Display all the Orders which are placed more than 10 days old and one or more items from those orders are still not shipped.

SELECT DISTINCT orders.order_id ,orders.order_date ,orders.amount ,orders_details.order_status FROM orders INNER JOIN orders_details

ON orders.order_id = orders_details.order_id 

WHERE DATEDIFF(NOW(),orders.order_date) > 10  

AND orders_details.order_status <> "shipped" 
AND orders_details.order_status <> "delivered"
AND orders_details.order_status <> "cancelled" ;


#4. Display list of shoppers which haven't ordered anything since last month.

SELECT user_id  ,firstname ,lastname ,email ,mobileno FROM user WHERE user.user_id 

NOT IN  (SELECT orders.user_id FROM orders WHERE DATEDIFF(NOW(),orders.order_date) <= 30)

AND user.role = "shopper";

#5. Display list of shopper along with orders placed by them in last 15 days. 

SELECT  product.product_name ,user.firstname, orders.order_id ,orders.order_date  FROM (((orders 

INNER JOIN orders_details ON orders.order_id = orders_details.order_id )

INNER JOIN product ON orders_details.product_id = product.product_id)

INNER JOIN user ON user.user_id = orders.user_id)

WHERE DATEDIFF(NOW(),orders.order_date) <= 15;

#6. Display list of order items which are in “shipped” state for particular Order Id (i.e.: 1020))

SELECT  product.product_name ,orders.order_id ,orders.order_date ,orders.amount ,orders_details.order_status FROM ((orders 

INNER JOIN orders_details ON orders.order_id = orders_details.order_id )

INNER JOIN product ON orders_details.product_id = product.product_id)

WHERE orders_details.order_status = "shipped" AND orders.order_id='O2';



#7. Display list of order items along with order placed date which fall between Rs 20 to Rs 50 price.

SELECT  product.product_name ,orders.order_id ,orders.order_date ,product.price FROM ((orders 

INNER JOIN orders_details ON orders.order_id = orders_details.order_id )

INNER JOIN product ON orders_details.product_id = product.product_id)

WHERE product.price  BETWEEN 120 AND 150;
