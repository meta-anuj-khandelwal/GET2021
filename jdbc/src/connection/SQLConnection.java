package connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * This class provide functionality to setup connection
 * 
 * @author anuj.khandelwal_meta
 *
 */
public class SQLConnection {
	private final static String path = "jdbc:mysql://localhost:3306/storefront";
	private final static String username = "root";
	private final static String password = "root";

	/**
	 * This function setup SQL connection and return object of connection.
	 * 
	 * @return connection object of Connection.
	 */
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(path, username, password);
		} catch (Exception e) {
			System.out.println(e);
		}
		return connection;
	}

}
