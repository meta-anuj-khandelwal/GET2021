package assignment5;

import java.sql.Timestamp;

/**
 * POJO class for orders table
 * 
 * @author anuj.khandelwal_meta
 *
 */
public class Orders {
	private String id;
	private Timestamp orderDate;
	private Double total;

	/**
	 * @param id
	 *            order id
	 * @param orderDate
	 *            date of order placing
	 * @param total
	 *            total order amount
	 */
	public Orders(String id, Timestamp orderDate, Double total) {
		this.id = id;
		this.orderDate = orderDate;
		this.total = total;
	}

	/**
	 * @return the order id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the orderDate
	 */
	public Timestamp getOrderDate() {
		return orderDate;
	}

	/**
	 * @param orderDate
	 *            the orderDate to set
	 */
	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}

	/**
	 * @return the total
	 */
	public Double getTotal() {
		return total;
	}

	/**
	 * @param total
	 *            the total to set
	 */
	public void setTotal(Double total) {
		this.total = total;
	}

	/**
	 * This function return order data in String format.
	 * 
	 * @return String rder data in String format.
	 */
	@Override
	public String toString() {
		return "id=" + id + ", orderDate=" + orderDate + ", total=" + total;
	}

}
