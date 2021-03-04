package Factory;

import java.util.List;

import Factory.Shape.ShapeType;

/**
 * <h1>ShapeFactory</h1>
 * <p>
 * This factory class is used to create various shape object based on shapeType.
 * 
 * </p>
 * 
 * @author Anuj Khandelwal
 * @version 1.0
 * @since 2021-03-03
 */
public class ShapeFactory {
	/**
	 * to get different shape object as per shapeType
	 * 
	 * @param shapeType
	 *            enum type of shape.
	 * @param point
	 *            Point origin point / center of shape
	 * @return Shape different shape object as per shapeType
	 */
	public static Shape createShape(ShapeType shapeType, Point point,
			List<Integer> parameters) {
		Shape shape;
		if (shapeType.compareTo(ShapeType.SQUARE) == 0) {
			shape = new Square(point, parameters.get(0));
		} else if (shapeType.compareTo(ShapeType.RECTANGLE) == 0) {
			shape = new Rectangle(point, parameters.get(0), parameters.get(1));
		} else if (shapeType.compareTo(ShapeType.CIRCLE) == 0) {
			shape = new Circle(point, parameters.get(0));
		} else if (shapeType.compareTo(ShapeType.TRIANGLE) == 0) {
			shape = new Triangle(point, parameters.get(0), parameters.get(1));
		} else {
			shape = new Polygon(point, parameters.get(0), parameters.get(1));
		}
		return shape;
	}
}
