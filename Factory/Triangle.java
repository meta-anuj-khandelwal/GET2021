package Factory;

/**
 * <h1>Triangle</h1>
 * <p>
 * This class is used to perform operation on Triangle. This implements Shape
 * interface
 * 
 * </p>
 * 
 * @author Anuj Khandelwal
 * @version 1.0
 * @since 2021-03-03
 */
public class Triangle implements Shape {
	Point startingPoint;
	int width;
	int height;

	/**
	 * @param startingPoint
	 * @param width
	 * @param height
	 */
	public Triangle(Point startingPoint, int width, int height) {
		super();
		this.startingPoint = startingPoint;
		this.width = width;
		this.height = height;
	}

	/**
	 * This method is used to calculate area of Triangle.
	 * 
	 * @return double area of
	 */
	@Override
	public double getArea() {
		double area = 0.5 * width * height;
		return area;
	}

	/**
	 * This method is used to calculate perimeter of Triangle.
	 * 
	 * @return double perimeter of Triangle
	 */
	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		double perimeter = (height + width + Math.sqrt(Math.pow(height, 2)
				+ Math.pow(width, 2)));
		return perimeter;
	}

	/**
	 * This method is used to get origin point / center of Triangle.
	 * 
	 * @return Point origin point / center of Triangle.
	 */
	@Override
	public Point getOrigin() {
		// TODO Auto-generated method stub
		return this.startingPoint;
	}

	/**
	 * This method is used to check weather point pt enclosed in Triangle or not
	 * 
	 * @return boolean true if point enclosed else false
	 */
	@Override
	public boolean isPointEnclosed(Point pt) {
		int x1 = startingPoint.getxCordintor();
		int y1 = startingPoint.getyCordintor();
		int x2 = startingPoint.getxCordintor();
		int y2 = startingPoint.getyCordintor() + height;
		int x3 = startingPoint.getxCordintor() + width;
		int y3 = startingPoint.getyCordintor();
		int x = pt.getxCordintor();
		int y = pt.getyCordintor();
		double triangleArea = areaUsingPoints(x1, y1, x2, y2, x3, y3);

		double firstArea = areaUsingPoints(x, y, x2, y2, x3, y3);

		double secondArea = areaUsingPoints(x1, y1, x, y, x3, y3);

		double thirdArea = areaUsingPoints(x1, y1, x2, y2, x, y);

		return (triangleArea == firstArea + secondArea + thirdArea);

	}

	private double areaUsingPoints(int x1, int y1, int x2, int y2, int x3,
			int y3) {
		double triangleArea = Math.abs((x1 * (y2 - y3) + x2 * (y3 - y1) + x3
				* (y1 - y2)) / 2.0);
		return triangleArea;
	}

	/**
	 * To get all parameter of Triangle in string
	 * 
	 * @return String all parameter of Triangle
	 */
	@Override
	public String toString() {
		return "Triangle [startingPoint=" + startingPoint + ", width=" + width
				+ ", height=" + height + "]";
	}

}
