package Factory;

/**
 * <h1>Circle</h1>
 * <p>
 * This class is used to perform operation on circle. This implements Shape
 * interface
 * 
 * </p>
 * 
 * @author Anuj Khandelwal
 * @version 1.0
 * @since 2021-03-03
 */
public class Circle implements Shape {
	Point startingPoint;
	int radius;

	/**
	 * @param startingPoint
	 *            Point starting point of circle
	 * @param radius
	 *            int radius of circle
	 */
	public Circle(Point startingPoint, int radius) {
		super();
		this.startingPoint = startingPoint;
		this.radius = radius;
	}

	/**
	 * This method is used to calculate area of circle.
	 * 
	 * @return double area of circle
	 */
	@Override
	public double getArea() {
		double area = (Math.PI * radius * radius);
		return area;
	}

	/**
	 * This method is used to calculate perimeter of circle.
	 * 
	 * @return double perimeter of circle
	 */
	@Override
	public double getPerimeter() {
		double perimeter = (Math.PI * radius * 2);
		return perimeter;
	}

	/**
	 * This method is used to get origin point / center of circle.
	 * 
	 * @return Point origin point / center of circle.
	 */
	@Override
	public Point getOrigin() {
		return this.startingPoint;
	}

	/**
	 * This method is used to check weather point pt enclosed in circle or not
	 * 
	 * @return boolean true if point enclosed else false
	 */
	@Override
	public boolean isPointEnclosed(Point pt) {
		boolean result;
		double distance = this.startingPoint.calculateDistance(pt);
		if (distance < this.radius)
			result = true;
		else
			result = false;
		return result;
	}

	/**
	 * To get all parameter of Polygon in Circle
	 * 
	 * @return String all parameter of Circle
	 */
	@Override
	public String toString() {
		return "Circle [startingPoint=" + startingPoint + ", radius=" + radius
				+ "]";
	}

}
