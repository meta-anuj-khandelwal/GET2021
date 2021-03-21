#Create a Stored procedure to retrieve average sales of each product in a month. Month and year will be input parameter to function.

DELIMITER $$

CREATE PROCEDURE average_sales(
    IN  month INT, 
    IN year INT
    )
BEGIN
    SELECT  product.product_name ,AVG(product.price) FROM (((product 

    INNER JOIN orders_details ON product.product_id = orders_details.product_id )

    INNER JOIN orders ON orders_details.order_id = orders.order_id)

    INNER JOIN user ON user.user_id = orders.user_id)
    
    WHERE MONTH(orders.order_date)=month AND YEAR(orders.order_date)=year 
    
    GROUP BY  product.product_id ;

END$$

DELIMITER ;

CALL average_sales(3,2021);



#Create a stored procedure to retrieve table having order detail with status for a given period. 
#Start date and end date will be input parameter. Put validation on input dates like start date is less than end date.
#If start date is greater than end date take first date of month as start date.


DELIMITER $$

CREATE PROCEDURE order_detail(
    IN  start_date DATE, 
    IN  end_date DATE
    )
BEGIN
    IF start_date > end_date THEN
        SET start_date= DATE_ADD(start_date, INTERVAL -DAY(start_date) + 1 DAY); 
    END IF;
    
    SELECT * FROM orders where orders.order_date BETWEEN start_date AND end_date;
END$$

DELIMITER ;

CALL order_detail("2021-03-23","2021-03-22");
 