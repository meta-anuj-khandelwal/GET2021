package Specification;

/**
 * <h1>Area</h1>
 * <p>
 * This class is designed to calculate area of different shapes <br>
 * 
 * </p>
 * 
 * @author Anuj Khandelwal
 * @version 1.0
 * @since 2021-02-28
 */
public class Area {
	/**
	 * This function is used to calculate triangle area.
	 * 
	 * @param width
	 *            double This parameter contains width of triangle ,greater than
	 *            0.
	 * @param height
	 *            double This parameter contains height of triangle ,greater
	 *            than 0.
	 * @return double area of triangle.
	 * 
	 */
	public static double triangleArea(double width, double height) {
		double area = 0.5 * width * height;
		return toTwoDecimalPlaces(area);
	}

	/**
	 * This function is used to calculate rectangle area.
	 * 
	 * @param width
	 *            double This parameter contains width of rectangle ,greater
	 *            than 0.
	 * @param height
	 *            double This parameter contains height of rectangle ,greater
	 *            than 0 .
	 * @return double area of rectangle.
	 * 
	 */

	public static double rectangleArea(double width, double height) {
		double area = width * height;
		return toTwoDecimalPlaces(area);
	}

	/**
	 * This function is used to calculate square area.
	 * 
	 * @param width
	 *            double This parameter contains width of square ,greater than
	 *            0.
	 * 
	 * @return double area of square.
	 * 
	 */

	public static double squareArea(double width) {
		double area = width * width;
		return toTwoDecimalPlaces(area);
	}

	/**
	 * This function is used to calculate circle area.
	 * 
	 * @param radius
	 *            double This contains radius of circle ,greater than 0.
	 * 
	 * @return double area of circle.
	 * 
	 */
	public static double circleArea(double radius) {
		double area = Math.PI * radius * radius;
		return toTwoDecimalPlaces(area);
	}

	/**
	 * This function is used to get floating-point values upto 2 decimal places.
	 * 
	 * @param number
	 *            double number to be round of
	 * @return double floating-point values upto 2 decimal places
	 */
	private static double toTwoDecimalPlaces(double number) {
		return Double.valueOf(String.format("%.2f", number));
	}

}
