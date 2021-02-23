package Assignment1;

import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingCart {
	private ArrayList<Product> cartItems = new ArrayList<Product>();

	/**
	 * This function is used to add product to cart.
	 * 
	 * @param product
	 *            This parameter contains the product which add to cart.
	 * @param quantity
	 *            This parameter contains quantity of product.
	 * @return boolean This return true if product successfully added to cart
	 *         else return false;
	 */
	public boolean addToCart(Product product, int quantity) {
		if (product.getQuantity() < quantity||quantity<=0) {
			return false;
		} else {
			String productName = product.getProductName();
			float productPrice = product.getPrice();
			int productQuantity = product.getQuantity() - quantity;
			product.setQuantity(productQuantity);
			cartItems.add(new Product(productName, productPrice, quantity));
			return true;
		}
	}

	/**
	 * This method is used to display cart content
	 * 
	 * @return nothing
	 */
	public void displayCart() {
		if (cartItems.size() == 0) {
			System.out.println("No product in cart");
			return;
		}
		System.out.println("Product Name\tOne unit price\tQuantity");
		for (int i = 0; i < cartItems.size(); i++) {
			System.out.println(cartItems.get(i).getProductName() + "\t\t"
					+ cartItems.get(i).getPrice() + "\t\t"
					+ cartItems.get(i).getQuantity());
		}
	}

	/**
	 * This method is used to generate and display bill
	 * 
	 * @return nothing
	 */
	public void generateBill() {
		if (cartItems.size() == 0) {
			System.out.println("No product in cart");
			return;
		}
		float totalBillAmount = 0;
		System.out.println("Product Name\tOne unit price\tQuantity\tTotal");
		for (int i = 0; i < cartItems.size(); i++) {
			float perItemTotalAmount = cartItems.get(i).getPrice()
					* cartItems.get(i).getQuantity();
			totalBillAmount += perItemTotalAmount;
			System.out.println(cartItems.get(i).getProductName() + "\t\t"
					+ cartItems.get(i).getPrice() + "\t\t"
					+ cartItems.get(i).getQuantity() + "\t\t"
					+ perItemTotalAmount);
		}
		System.out.println("-----------------------------");
		System.out.println("Total bill Amount : " + totalBillAmount);
	}

	/**
	 * This function is used to update quantity in cart.
	 * @return boolean This return true if product updated successfully else
	 *         return false;
	 */
	public boolean updateCart() {
		displayCart();
		if (cartItems.size() == 0) {
			return false;
		}
		int productNumber = 0;
		int quantity = 0;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter product number to update qunatity ");
		productNumber = scan.nextInt();
		
		if (productNumber > cartItems.size()) {
			System.out.println("Invalid Product number...");
			return false;
		}
		
		System.out.println("Enter new Quantity");
		quantity = scan.nextInt();
		if (quantity < 0) {
			return false;
		}
		if(quantity==0){
			cartItems.remove(productNumber - 1);
			return true;
		}
		cartItems.get(productNumber - 1).setQuantity(quantity);
		return true;

	}

	/**
	 * main method to run the program
	 * 
	 * @return nothing
	 */
	public static void main(String[] args) {
		ArrayList<Product> products = new ArrayList<Product>();
		ShoppingCart shoppingCart = new ShoppingCart();
		Scanner scan = new Scanner(System.in);
		int choice;
		products.add(new Product("Parle-H", 10, 100));
		products.add(new Product("Maggie", 20, 50));
		products.add(new Product("Chips", 15, 80));
		
		//Displaying available product in store
		System.out.println("Product Name\tOne unit price\tQuantity");
		for (int i = 0; i < products.size(); i++) {
			System.out.println(products.get(i).getProductName() + "\t\t"
					+ products.get(i).getPrice() + "\t\t"
					+ products.get(i).getQuantity());
		}
		
		while (true) {
			System.out.println("1] Add to cart");
			System.out.println("2] Update cart");
			System.out.println("3] Display cart");
			System.out.println("4] Generate bill");
			System.out.println("5] Exit");
			System.out.println("Enter Your Choice :");
			choice = scan.nextInt();
			switch (choice) {
			case 1:
				int productNumber = 0;
				int quantity = 0;
				System.out.println("Enter product number : ");
				productNumber = scan.nextInt();
				if (productNumber > products.size()) {
					System.out.println("Invalid Product number...");
					break;
				}
				System.out.println("Enter Quantity");
				quantity = scan.nextInt();
				boolean status = shoppingCart.addToCart(
						products.get(productNumber - 1), quantity);
				if (status) {
					System.out.println("Product added successfully");
				} else {
					System.out.println("Something went wrong");
				}
				break;
			case 2:
				shoppingCart.updateCart();
				break;
			case 3:
				shoppingCart.displayCart();
				break;
			case 4:
				shoppingCart.generateBill();
				break;
			case 5:
				return;
			default:
				System.out.println("Invalid input...");
			}
		}
	}
}
