package Assignment3;

/**
 * <h1>Poly</h1>
 * <p>
 * This is an immutable class designed to perform following polynomial equation
 * operations <br>
 * Evaluate Polynomial equation<br>
 * Add two polynomials <br>
 * Multiply two polynomials <br>
 * 
 * </p>
 * 
 * @author Anuj Khandelwal
 * @version 1.0
 * @since 2021-02-26
 */
final public class Poly {
	final private int degree;
	private int polyArray[];

	/**
	 * Constructor to make polynomial equation using array.
	 * 
	 * @param arr
	 *            Array to initiate Polynomial Coefficient.
	 */
	Poly(int polyArray[]) {
		this.polyArray = new int[polyArray.length];
		for (int i = 0; i < polyArray.length; i++) {
			this.polyArray[i] = polyArray[i];
		}
		int maxDegree = 0;
		for (int i = polyArray.length - 1; i >= 0; i--) {
			if (polyArray[i] != 0) {
				maxDegree = i;
				break;
			}
		}
		this.degree = maxDegree;
	}

	public Poly() {
		degree = 0;
		this.polyArray = new int[0];
	}

	/**
	 * This function is used to evaluate a polynomial for given value of
	 * variable.
	 * 
	 * @param var
	 *            value of polynomial variable.
	 * @return float solution a polynomial for given value of variable
	 * 
	 */
	public float evaluate(float var) {
		float result = 0.0f;
		for (int i = 0; i <= degree; i++) {
			result = (float) (result + (polyArray[i] * Math.pow(var, i)));
		}
		return result;
	}

	/**
	 * This function is used to fetch degree of polynomial.
	 * 
	 * @return int degree of polynomial
	 */
	public int degree() {
		return this.degree;
	}

	/**
	 * This function is used to add two polynomial equations.
	 * 
	 * @param p1
	 *            first polynomial object.
	 * @param p2
	 *            second polynomial object.
	 * 
	 * @return Poly new polynomial after addition.
	 * 
	 */
	public static Poly addPoly(Poly p1, Poly p2) {
		Poly addition;
		int maximumDegree = p1.degree() > p2.degree() ? p1.degree() : p2
				.degree();
		int pArray[] = new int[maximumDegree+1];
		int i = 0;
		if (p1.degree() > p2.degree()) {
			for (i = 0; i <= p2.degree(); i++) {
				pArray[i] = p1.polyArray[i] + p2.polyArray[i];
			}
			for (; i <= p1.degree(); i++) {
				pArray[i] = p1.polyArray[i];
			}

		} else {
			for (i = 0; i <= p1.degree(); i++) {
				pArray[i] = p1.polyArray[i] + p2.polyArray[i];
			}
			for (; i <= p2.degree(); i++) {
				pArray[i] = p2.polyArray[i];
			}
		}
		addition = new Poly(pArray);
		return addition;
	}

	/**
	 * This function is used to multiply two polynomial equations.
	 * 
	 * @param p1
	 *            first polynomial object.
	 * @param p2
	 *            second polynomial object.
	 * 
	 * @return Poly new polynomial after multiplication.
	 * 
	 */
	public static Poly multiplyPoly(Poly p1, Poly p2) {

		int pArray[] = new int[(p1.degree()+1) * (p2.degree()+1) + 1];
		for (int i = 0; i <= p1.degree(); i++) {
			for (int j = 0; j <= p2.degree(); j++) {
				pArray[i + j] += p1.polyArray[i] * p2.polyArray[j];
			}
		}

		return new Poly(pArray);
	}

	/**
	 * This function is used to print coefficient of polynomial.
	 * 
	 * @return nothing
	 * 
	 */
	public void print() {
		for (int i = 0; i <= degree; i++) {
			if (polyArray[i] == 0)
				continue;
			else {
				if (polyArray[i] < 0)
					System.out.print(polyArray[i] + "x^" + (i));
				else {
					if (i != 0)
						System.out.print("+" + polyArray[i] + "x^" + (i));
					else {
						System.out.print(polyArray[i] + "x^" + (i));
					}

				}
			}
		}
		System.out.println();
	}

}
