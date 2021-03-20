#1. Display Id, Title, Category Title, Price of the products which are Active and recently added products should be at top.

SELECT product.product_id  ,cat.category_title ,product.price ,product.addition_date FROM product ,product_category cat ,product_category_mapper cat_mapper

WHERE  cat_mapper.product_id=product.product_id AND cat_mapper.category_id=cat.category_id  AND  product.status='yes' 

ORDER BY product.addition_date DESC;


#2. Display the list of products which don't have any images.

SELECT DISTINCT product.product_id ,product.product_name FROM product , product_image 

WHERE product_image.product_id=product.product_id;

#3. Display all Id, Title and Parent Category Title for all the Categories listed, sorted by Parent Category Title.
#and then Category Title. (If Category is top category then Parent Category Title column should display “Top Category” as value.)

SELECT category.category_id AS ID, category.category_title AS Title,

IFNULL(parent_category.category_title, "Top Category" ) AS Parent_Category

FROM product_category category LEFT JOIN product_category parent_category

ON category.parent_category_id  = parent_category.category_id 

ORDER BY parent_category.category_title, category.category_title ;


#####4. Display Id, Title, Parent Category Title of all the leaf Categories (categories which are not parent of any other category)


SELECT category_id from product_category where category_id not in (SELECT parent_category_id from product_category);

#5. Display Product Title, Price & Description which falls into particular category Title (i.e. “Mobile”)

SELECT product_name AS Title , price , description FROM product WHERE product_id IN 

(SELECT product_id FROM product_category_mapper INNER JOIN product_category

ON product_category.category_id = product_category_mapper.category_id 

WHERE category_title="mobile");


#6. Display the list of Products whose Quantity on hand (Inventory) is under 50.

SELECT * FROM product where quantity <= 50;
