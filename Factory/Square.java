package Factory;

/**
 * <h1>Square</h1>
 * <p>
 * This class is used to perform operation on Square. This implements Shape
 * interface
 * 
 * </p>
 * 
 * @author Anuj Khandelwal
 * @version 1.0
 * @since 2021-03-03
 */
public class Square implements Shape {
	Point startingPoint;
	int width;

	/**
	 * @param startingPoint
	 * @param width
	 */
	public Square(Point startingPoint, int width) {

		this.startingPoint = startingPoint;
		this.width = width;
	}

	/**
	 * This method is used to calculate area of Square.
	 * 
	 * @return double area of Square
	 */
	@Override
	public double getArea() {
		double area = width * width;
		return area;
	}

	/**
	 * This method is used to calculate perimeter of Square.
	 * 
	 * @return double perimeter of
	 */
	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		double perimeter = 4 * width;
		return perimeter;
	}

	/**
	 * This method is used to get origin point / center of Square.
	 * 
	 * @return Point origin point / center of .
	 */
	@Override
	public Point getOrigin() {
		// TODO Auto-generated method stub
		return this.startingPoint;
	}

	/**
	 * This method is used to check weather point pt enclosed in Square or not
	 * 
	 * @return boolean true if point enclosed else false
	 */
	@Override
	public boolean isPointEnclosed(Point pt) {
		int topRightCordinateX = pt.getxCordintor() + width;
		int topRightCordinateY = pt.getyCordintor() + width;
		boolean result = false;
		if (pt.getxCordintor() > startingPoint.getxCordintor()
				&& pt.getxCordintor() < topRightCordinateX
				&& pt.getyCordintor() > startingPoint.getyCordintor()
				&& pt.getyCordintor() < topRightCordinateY) {
			result = true;
		}
		return result;
	}

	/**
	 * To get all parameter of Square in string
	 * 
	 * @return String all parameter of Square
	 */
	@Override
	public String toString() {
		return "Square [startingPoint=" + startingPoint + ", width=" + width
				+ "]";
	}

}
