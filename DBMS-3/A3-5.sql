#Create a view displaying the order information (Id, Title, Price, Shopper’s name, Email, Orderdate, Status) 
#with latest ordered items should be displayed first for last 60 days.


CREATE VIEW  order_information AS

SELECT product.product_id AS Id , 

product.product_name AS Title ,

product.price AS Price ,

user.firstname AS Name,

user.email AS Email,

orders.order_date AS OrderDate,

orders_details.order_status AS Status

 FROM (((product 

INNER JOIN orders_details ON product.product_id = orders_details.product_id )

INNER JOIN orders ON orders_details.order_id = orders.order_id )

INNER JOIN user ON user.user_id =orders.user_id)

WHERE DATEDIFF(NOW(),orders.order_date) <= 60

ORDER BY orders.order_date DESC;


SELECT * FROM order_information;

#Use the above view to display the Products(Items) which are in ‘shipped’ state.

SELECT * FROM order_information WHERE Status="shipped";

#Use the above view to display the top 5 most selling products.

SELECT Title ,COUNT(Id) FROM order_information 

GROUP BY Id

ORDER BY COUNT(Id) DESC

LIMIT 5;