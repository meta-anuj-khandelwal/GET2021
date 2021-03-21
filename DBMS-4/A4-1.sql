#Create a function to calculate number of orders in a month. Month and year will be input parameter to function.

DELIMITER $$  
CREATE FUNCTION number_of_orders (month int , year int  )   
RETURNS int
DETERMINISTIC  
BEGIN  
    DECLARE total_order int;
    SET total_order = (SELECT COUNT(order_id) FROM orders WHERE  MONTH(order_date)= month AND YEAR(order_date)=year);
    RETURN (total_order);  
END$$  
DELIMITER ;

SELECT number_of_orders(3,2021);


#Create a function to return month in a year having maximum orders. Year will be input parameter.
DELIMITER $$  
CREATE FUNCTION maximum_order_month ( year int  )   
RETURNS int
DETERMINISTIC  
BEGIN  
    DECLARE max_order_month int;
    
    SET max_order_month = (
    SELECT MONTH(order_date) FROM orders 
    
    WHERE YEAR(order_date)=year 
    
    GROUP BY MONTH(order_date)
    
    ORDER BY COUNT(order_id) 
    
    DESC LIMIT 1);
    
    RETURN (max_order_month);  
END$$  
DELIMITER ;

SELECT maximum_order_month(2020);

