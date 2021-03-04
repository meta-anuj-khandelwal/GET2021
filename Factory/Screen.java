package Factory;

/**
 * <h1>Screen</h1>
 * <p>
 * This class is used to denote a screen which contains various shapes with their timestamp.
 * 
 * </p>
 * 
 * @author Anuj Khandelwal
 * @version 1.0
 * @since 2021-03-03
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;

import Factory.Shape.ShapeType;
import Factory.ShapeComparator.sortBase;

public class Screen {
	// list of shapes
	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	// map to map shape with date
	HashMap<Shape, Date> map = new HashMap<Shape, Date>();

	/**
	 * @return the shapes
	 */
	public ArrayList<Shape> getShapes() {
		return shapes;
	}

	/**
	 * @param shapes the shapes to set
	 */
	public void setShapes(ArrayList<Shape> shapes) {
		this.shapes = shapes;
	}

	/**
	 * to add shape object to screen
	 * 
	 * @param shape1
	 *            Shape object which is to be added on screen.
	 * 
	 * @return nothing
	 */
	void addShape(Shape shape, Date date) {
		shapes.add(shape);
		map.put(shape, date);
	}

	/**
	 * to remove shape object from screen
	 * 
	 * @param shape1
	 *            Shape object which is to be deleted from screen.
	 * 
	 * @return nothing
	 */
	void deleteShape(Shape shape) {
		shapes.remove(shape);
		map.remove(shape);
	}

	/**
	 * to remove all shape object of specified type.
	 * 
	 * @param ShapeType
	 *            Type of shape
	 * 
	 * @return nothing
	 */
	void deleteAllShape(Shape.ShapeType shapeType) {
		// setting class name of shape
		String className = new String();
		if (shapeType.compareTo(ShapeType.SQUARE) == 0) {
			className = "class Factory.Square";
		} else if (shapeType.compareTo(ShapeType.RECTANGLE) == 0) {
			className = "class Factory.Rectangle";

		} else if (shapeType.compareTo(ShapeType.CIRCLE) == 0) {
			className = "class Factory.Circle";

		} else if (shapeType.compareTo(ShapeType.TRIANGLE) == 0) {
			className = "class Factory.Triangle";

		} else if (shapeType.compareTo(ShapeType.POLYGON) == 0) {
			className = "class Factory.Polygon";

		}
		// remove all shape object of specified type from list and map
		for (int shapeIndex = 0; shapeIndex < shapes.size(); shapeIndex++) {

			if (String.valueOf(shapes.get(shapeIndex).getClass()).equals(
					className)) {
				map.remove(shapes.get(shapeIndex));
				shapes.remove(shapeIndex);
				shapeIndex--;
			}

		}
	}

	/**
	 * to sort all shape object on basic of area, perimeter, timestamp,distance
	 * from origin.
	 * 
	 * @param base
	 *            sortBase basis or sorting
	 * 
	 * @return nothing
	 */
	void sortShapes(sortBase base) {
		Collections.sort(shapes, new ShapeComparator(base, map));
	}

	/**
	 * to get all shape object which enclose specified point
	 * 
	 * @param base
	 *            sortBase basis or sorting
	 * @param pt
	 *            Point whose enclosing shape need to get
	 * @return ArrayList<Shape> all shape object which enclose specified point
	 */
	public ArrayList<Shape> getEnclosingShapes(Point pt) {
		// list of enclosing shapes
		ArrayList<Shape> enclosingShapes = new ArrayList<Shape>();

		for (int shapeIndex = 0; shapeIndex < this.shapes.size(); shapeIndex++) {
			if (shapes.get(shapeIndex).isPointEnclosed(pt)) {
				enclosingShapes.add(shapes.get(shapeIndex));
			}
		}
		return enclosingShapes;
	}

	/**
	 * to get all on screen shapes with their time stamp in String.
	 * 
	 * @return String screen shapes with their time stamp
	 */
	@Override
	public String toString() {
		return "Screen [shapes=" + shapes + ", map=" + map + "]";
	}

}
