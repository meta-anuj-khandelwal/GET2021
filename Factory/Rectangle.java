package Factory;
/**
 * <h1>Rectangle</h1>
 * <p>
 * This class is used to perform operation on Rectangle. This implements Shape
 * interface
 * 
 * </p>
 * 
 * @author Anuj Khandelwal
 * @version 1.0
 * @since 2021-03-03
 */
public class Rectangle implements Shape {
	Point startingPoint;
	int width;
	int height;

	/**
	 * @param startingPoint
	 * @param width
	 * @param height
	 */
	public Rectangle(Point startingPoint, int width, int height) {
		super();
		this.startingPoint = startingPoint;
		this.width = width;
		this.height = height;
	}

	/**
	 * This method is used to calculate area of Rectangle.
	 * 
	 * @return double area of Rectangle.
	 */
	@Override
	public double getArea() {
		double area = width * height;
		return area;
	}

	/**
	 * This method is used to calculate perimeter of Rectangle.
	 * 
	 * @return double perimeter of Rectangle
	 */
	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		double perimeter = 2 * (height + width);
		return perimeter;
	}

	/**
	 * This method is used to get origin point / center of Rectangle.
	 * 
	 * @return Point origin point / center of Rectangle.
	 */
	@Override
	public Point getOrigin() {
		// TODO Auto-generated method stub
		return this.startingPoint;
	}

	/**
	 * This method is used to check weather point pt enclosed in Rectangle or
	 * not
	 * 
	 * @return boolean true if point enclosed else false
	 */
	@Override
	public boolean isPointEnclosed(Point pt) {
		int topRightCordinateX = pt.getxCordintor() + width;
		int topRightCordinateY = pt.getyCordintor() + height;
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
	 * To get all parameter of Rectangle in string
	 * 
	 * @return String all parameter of Rectangle
	 */
	@Override
	public String toString() {
		return "Rectangle [startingPoint=" + startingPoint + ", width=" + width
				+ ", height=" + height + "]";
	}

}
