package assignment5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.SQLConnection;

public class Main {
	/**
	 * This function fetch order (Id, Order Date, Order Total) of the user which
	 * are in shipped state.
	 * 
	 * @param userId
	 *            Id of user whose order to be find
	 * @return List<Orders> which are in shipped state.
	 */
	public static List<Orders> fetchOrders(String userId) {
		final String query = "SELECT order_id, order_date, amount from orders WHERE order_status=? AND user_id=? ORDER BY order_date";
		List<Orders> orderList = new ArrayList<Orders>();
		try {
			// connection setup
			Connection connection = SQLConnection.getConnection();
			// statement creation
			PreparedStatement preparedStatement = connection
					.prepareStatement(query);
			preparedStatement.setString(1, "shipped");
			preparedStatement.setString(2, userId);
			// fetching SQL data
			ResultSet resultSet = preparedStatement.executeQuery();
			// traversing every row and adding in to List
			while (resultSet.next()) {
				Orders orders = new Orders(resultSet.getString(1),
						resultSet.getTimestamp(2), resultSet.getDouble(3));
				orderList.add(orders);
			}

		} catch (Exception e) {
			System.err.println(e);
		}
		return orderList;
	}

	/**
	 * This function insert image corresponds to product_id using batch update.
	 * 
	 */
	public static void insertImage() {
		// all query
		String[] queries = {
				"insert into product_image (image_id,product_id ,image_address) values ('i20', 'p6', 'p6/path1')",
				"insert into product_image (image_id,product_id ,image_address) values ('i21', 'p6', 'p6/path2')",
				"insert into product_image (image_id,product_id ,image_address) values ('i22', 'p6', 'p6/path3')",
				"insert into product_image (image_id,product_id ,image_address) values ('i23', 'p6', 'p6/path4')",
				"insert into product_image (image_id,product_id ,image_address) values ('i24', 'p6', 'p6/path5')", };

		try {
			// connection setup
			Connection connection = SQLConnection.getConnection();
			// creating statement
			Statement statement = connection.createStatement();
			// adding statement
			for (String query : queries) {
				statement.addBatch(query);
			}
			// executing all query
			statement.executeBatch();
			statement.close();
			connection.close();
		} catch (Exception e) {
			System.err.println(e);
		}

	}

	/**
	 * This function Delete all those products which were not ordered by any
	 * Shopper in last 1 year. Return the number of products deleted.
	 * 
	 * 
	 * @return number of deleted Product
	 */
	public static int deleteProduct() {
		int deletedProductCount = 0;
		// query
		String query = "DELETE from product "
				+ " WHERE product.product_id NOT IN "
				+ "(SELECT  orders_details.product_id from orders_details "
				+ "INNER JOIN orders ON orders.order_id = orders_details.order_id "
				+ "WHERE DATEDIFF(NOW(),orders.order_date) <= 365 "
				+ "GROUP BY (orders_details.product_id));";
		try {
			// connection setup
			Connection connection = SQLConnection.getConnection();
			// creating statement
			Statement statement = connection.createStatement();
			// to manage foreign_key_checks
			statement.executeUpdate("set foreign_key_checks =0");
			deletedProductCount = statement.executeUpdate(query);
			statement.close();
			connection.close();
		} catch (Exception e) {
			System.err.println(e);
		}
		return deletedProductCount;
	}

	/**
	 * This function display the category title of all top parent categories
	 * sorted alphabetically and the count of their child categories.
	 *
	 * @return List<ProductCategory> ProductCategory details.
	 */
	public static List<ProductCategory> fetchCategoryData() {
		final String query = "SELECT top_cat.category_id, top_cat.category_title, COUNT(child_cat.category_id)"
				+ " FROM product_category top_cat LEFT JOIN product_category child_cat"
				+ " ON top_cat.category_id=child_cat.parent_category_id"
				+ " WHERE top_cat.parent_category_id is null "
				+ " GROUP BY top_cat.category_id"
				+ " ORDER BY top_cat.category_title";
		List<ProductCategory> categories = new ArrayList<ProductCategory>();
		try {
			// connection setup
			Connection connection = SQLConnection.getConnection();
			// statement creation
			Statement statement = connection.createStatement();

			// fetching SQL data
			ResultSet resultSet = statement.executeQuery(query);
			// traversing every row and adding in to List
			while (resultSet.next()) {
				ProductCategory category = new ProductCategory(
						resultSet.getString(1), resultSet.getString(2),
						resultSet.getInt(3));
				categories.add(category);
			}

		} catch (Exception e) {
			System.err.println(e);
		}
		return categories;
	}

	public static void main(String[] args) {
		System.out.println("ORDERS :\n" + fetchOrders("8"));
		insertImage();
		System.out.println("Deleted product count : " + deleteProduct());
		System.out.println("CategoryData : \n" + fetchCategoryData());
	}
}
