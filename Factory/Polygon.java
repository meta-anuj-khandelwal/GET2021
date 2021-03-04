package Factory;

/**
 * <h1>Polygon</h1>
 * <p>
 * This class is used to perform operation on polygon. This implements Shape
 * interface
 * 
 * </p>
 * 
 * @author Anuj Khandelwal
 * @version 1.0
 * @since 2021-03-03
 */
public class Polygon implements Shape {
	Point startingPoint;
	int side;
	int numberOfSide;

	/**
	 * @param startingPoint
	 * @param side
	 * @param numberOfSide
	 */
	public Polygon(Point startingPoint, int numberOfSide, int side) {
		super();
		this.startingPoint = startingPoint;
		this.side = side;
		this.numberOfSide = numberOfSide;
	}

	/**
	 * This method is used to calculate area of Polygon.
	 * 
	 * @return double area of Polygon
	 */
	@Override
	public double getArea() {

		double area = (side * side * numberOfSide)
				/ (4 * Math.tan(Math.PI / numberOfSide));
		return area;
	}

	/**
	 * This method is used to calculate perimeter of Polygon.
	 * 
	 * @return double perimeter of Polygon
	 */
	@Override
	public double getPerimeter() {
		float perimeter = side * numberOfSide;
		return perimeter;
	}

	/**
	 * This method is used to get origin point / center of Polygon.
	 * 
	 * @return Point origin point / center of Polygon.
	 */
	@Override
	public Point getOrigin() {
		// TODO Auto-generated method stub
		return this.startingPoint;
	}

	/**
	 * This method is used to check weather point pt enclosed in Polygon or not
	 * 
	 * @return boolean true if point enclosed else false
	 */
	@Override
	public boolean isPointEnclosed(Point pt) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * To get all parameter of Polygon in string
	 * 
	 * @return String all parameter of Polygon
	 */
	@Override
	public String toString() {
		return "Polygon [startingPoint=" + startingPoint + ", side=" + side
				+ ", numberOfSide=" + numberOfSide + "]";
	}

}
