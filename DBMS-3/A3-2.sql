#Display the list of products (Id, Title, Count of Categories) which fall in more than one Categories.


SELECT product.product_id,product.product_name,COUNT(product_category_mapper.product_id) FROM( (product

INNER JOIN  product_category_mapper on product_category_mapper.product_id=product.product_id)

inner join product_category on product_category.category_id=product_category_mapper.category_id)

GROUP BY product.product_id ;

#Display Count of products as per below price range: Range in Rs. Count 0 - 100 and 101 - 500 and Above 500

SELECT COUNT(product.product_id) FROM product WHERE product.price BETWEEN 0 AND 100;
SELECT COUNT(product.product_id) FROM product WHERE product.price BETWEEN 101 AND 500;
SELECT COUNT(product.product_id) FROM product WHERE product.price > 500;

#Display the Categories along with number of products under each category.
SELECT product_category.category_id,product_category.category_title, COUNT(product_category_mapper.product_id) FROM product_category 

INNER JOIN product_category_mapper ON product_category_mapper.category_id = product_category.category_id
 
GROUP BY product_category.category_id ;