package Factory;

import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;

/**
 * <h1>ShapeComparator</h1>
 * <p>
 * This class is used to get Comparator on different sortBase.
 * 
 * </p>
 * 
 * @author Anuj Khandelwal
 * @version 1.0
 * @since 2021-03-03
 */
public class ShapeComparator implements Comparator<Shape> {
	// sorting base
	public enum sortBase {
		AREA, PERIMETER, TIMESTAMP, ORIGINDISTANCE
	}

	// to map shape with timestamp
	HashMap<Shape, Date> map;

	// to store sorting base of Comparator.
	sortBase soritngBase;

	/**
	 * constructor
	 * 
	 * @param base
	 *            enum sorting base.
	 * @param map
	 *            HashMap<Shape, Date> to map shape with timestamp
	 */
	public ShapeComparator(sortBase base, HashMap<Shape, Date> map) {
		soritngBase = base;
		this.map = map;
	}

	/**
	 * to compare two shape object
	 * 
	 * @param shape1
	 *            Shape first object which is to be compared.
	 * @param shape1
	 *            Shape second object which is to be compared.
	 * @return 1 if shape1 > shape2 ,0 if shape1 = shape2, -1 if shape1< shape2
	 */
	@Override
	public int compare(Shape shape1, Shape shape2) {
		// calling helper function as per sort base
		if (soritngBase.compareTo(sortBase.AREA) == 0) {
			return areaCompare(shape1, shape2);
		} else if (soritngBase.compareTo(sortBase.PERIMETER) == 0) {
			return perimeterCompare(shape1, shape2);
		} else if (soritngBase.compareTo(sortBase.TIMESTAMP) == 0) {
			return timestampCompare(shape1, shape2);
		} else {
			return origindistanceCompare(shape1, shape2);
		}
	}

	/**
	 * helper method to compare two shape object on the basis of origin distance
	 * 
	 * @param shape1
	 *            Shape first object which is to be compared.
	 * @param shape1
	 *            Shape second object which is to be compared.
	 * @return 1 if shape1 > shape2 ,0 if shape1 = shape2, -1 if shape1< shape2
	 */
	private int origindistanceCompare(Shape shape1, Shape shape2) {
		if (shape1.getOrigin().distanceFromOrigin() > shape2.getOrigin()
				.distanceFromOrigin()) {
			return 1;
		} else if (shape1.getOrigin().distanceFromOrigin() < shape2.getOrigin()
				.distanceFromOrigin()) {
			return -1;
		}
		return 0;
	}

	/**
	 * helper method to compare two shape object on the basis of timestamp
	 * 
	 * @param shape1
	 *            Shape first object which is to be compared.
	 * @param shape1
	 *            Shape second object which is to be compared.
	 * @return 1 if shape1 > shape2 ,0 if shape1 = shape2, -1 if shape1< shape2
	 */
	private int timestampCompare(Shape shape1, Shape shape2) {
		// TODO Auto-generated method stub
		return map.get(shape1).compareTo(map.get(shape2));
	}

	/**
	 * helper method to compare two shape object on the basis of perimeter
	 * 
	 * @param shape1
	 *            Shape first object which is to be compared.
	 * @param shape1
	 *            Shape second object which is to be compared.
	 * @return 1 if shape1 > shape2 ,0 if shape1 = shape2, -1 if shape1< shape2
	 */
	private int perimeterCompare(Shape shape1, Shape shape2) {
		if (shape1.getPerimeter() > shape2.getPerimeter()) {
			return 1;
		} else if (shape1.getPerimeter() < shape2.getPerimeter()) {
			return -1;
		}
		return 0;
	}

	/**
	 * helper method to compare two shape object on the basis of area
	 * 
	 * @param shape1
	 *            Shape first object which is to be compared.
	 * @param shape1
	 *            Shape second object which is to be compared.
	 * @return 1 if shape1 > shape2 ,0 if shape1 = shape2, -1 if shape1< shape2
	 */
	private int areaCompare(Shape shape1, Shape shape2) {
		if (shape1.getArea() > shape2.getArea()) {
			return 1;
		} else if (shape1.getArea() < shape2.getArea()) {
			return -1;
		}
		return 0;
	}
}
