package dsaassignment1;

import java.util.Scanner;

/**
 * <h1>Polynomial</h1>
 * <p>
 * This class is used to implement multivariate polynomial using linked list
 * data structure.
 * 
 * </p>
 * 
 * @author Anuj Khandelwal
 * @version 1.0
 * @since 2021-03-04
 */
public class Polynomial {
	/*
	 * nested list to store various term and their degree of multivariate
	 * polynomial. inner list's 0th index element contain power of first
	 * variable,1st index element contain power of second variable and so on.
	 */
	private MyLinkList<MyLinkList<Integer>> polynomial = new MyLinkList<MyLinkList<Integer>>();

	/**
	 * this function used to create polynomial from user input and convert to
	 * nested list representation of polynomial and than calculate degree.
	 * 
	 * @return int degree of polynomial.
	 */
	public int polyDegree() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter totalTerms :");

		int totalTerms = scanner.nextInt();
		System.out.println("Enter totalVariables :");

		int totalVariables = scanner.nextInt();

		for (int termNumber = 0; termNumber < totalTerms - 1; termNumber++) {

			polynomial.add(new MyLinkList<Integer>());

			char var = 'a' - 1;

			for (int variableNumber = 0; variableNumber < totalVariables; variableNumber++) {
				System.out.println("Enter " + ((char) (var + 1)) + ":^");
				int power = scanner.nextInt();
				polynomial.get(termNumber).add(power);
				var++;
			}

			System.out.println("Enter coefficient :");
			int coefficient = scanner.nextInt();

			polynomial.get(termNumber).add(coefficient);
		}

		polynomial.add(new MyLinkList<Integer>());

		System.out.println("Enter constant :");
		int constant = scanner.nextInt();

		polynomial.get(totalTerms - 1).add(constant);
		// calculate degree of polynomial.
		int degree = getPolyDegree(polynomial);
		return degree;

	}

	/**
	 * this function used to calculate degree of polynomial.
	 * 
	 * @param polynomial
	 *            MyLinkList<MyLinkList<Integer>> multivariate polynomial using
	 *            linked list.
	 * @return int degree of polynomial.
	 */
	public static int getPolyDegree(MyLinkList<MyLinkList<Integer>> polynomial) {
		// total terms in polynomial except constant
		int totalTerms = polynomial.getSize() - 1;

		// total number of polynomial variables
		int totalVariables = polynomial.get(0).getSize() - 1;

		int degree = 0;

		for (int termNumber = 0; termNumber < totalTerms; termNumber++) {
			int currentermDegree = 0;
			for (int variableNumber = 0; variableNumber < totalVariables; variableNumber++) {
				// adding all power of one polynomial term.
				currentermDegree += polynomial.get(termNumber).get(
						variableNumber);
			}
			if (currentermDegree > degree) {
				degree = currentermDegree;
			}

		}
		return degree;
	}
}
