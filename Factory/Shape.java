package Factory;

/**
 * <h1>Shape</h1>
 * <p>
 * This class is base class for all the Shapes
 * 
 * </p>
 * 
 * @author Anuj Khandelwal
 * @version 1.0
 * @since 2021-03-03
 */
public interface Shape {

	public enum ShapeType {
		SQUARE, RECTANGLE, CIRCLE, TRIANGLE, POLYGON
	}

	/**
	 * This method is used to calculate area of different shapes.
	 * 
	 * @return double area of shape
	 */
	public double getArea();

	/**
	 * This method is used to calculate perimeter of different shapes.
	 * 
	 * @return double perimeter of shape
	 */
	public double getPerimeter();

	/**
	 * This method is used to get origin point / center of shapes.
	 * 
	 * @return Point origin point / center of shapes.
	 */
	public Point getOrigin();

	/**
	 * This method is used to check weather point pt enclosed in shape or not
	 * 
	 * @return boolean true if point enclosed else false
	 */
	public boolean isPointEnclosed(Point pt);
}
