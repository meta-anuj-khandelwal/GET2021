package Factory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;

import Factory.Shape.ShapeType;
import Factory.ShapeComparator.sortBase;

public class Main {
	public static int readIntFromConsel() {
		int number;
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		while (true) {
			try {
				number = Integer.parseInt(bufferedReader.readLine());
				break;
			} catch (Exception e) {
				System.out.println("Something went wrong\n please re enter :");
			}
		}
		return number;

	}

	public static void main(String[] args) {

		Screen screen = new Screen();
		while (true) {

			System.out.println("1]Add a shape object");
			System.out.println("2]Delete a shape object from the screen");
			System.out.println("3]Delete all shape objects of a specific type");
			System.out.println("4]Sort shapes");
			System.out.println("5]show all shapes");
			System.out.println("6]list of shape enclosing a specified point");
			System.out.println("7]exit");
			int choice = readIntFromConsel();
			switch (choice) {
			case 1:
				Shape shape = createShape();
				screen.addShape(shape, new Date());
				System.out.println("Shape addes successfully");
				break;
			case 2:
				ArrayList<Shape> shapeList = screen.getShapes();
				showShapes(shapeList);
				int shapeNumber = readIntFromConsel();
				if (shapeNumber >= 1 && shapeNumber <= shapeList.size()) {
					screen.deleteShape(shapeList.get(shapeNumber - 1));
					System.out.println("Shape deleted successfully");
				} else {
					System.out.println("Invalid Input");
				}
				break;
			case 3:
				System.out.println("1]Delete Circles");
				System.out.println("2]Delete Triangle");
				System.out.println("3]Delete Square");
				System.out.println("4]Delete Rectangle");
				System.out.println("5]Delete Polygon");
				int shapechoice = readIntFromConsel();
				if (shapechoice >= 1 && shapechoice <= 5) {
					switch (shapechoice) {
					case 1:
						screen.deleteAllShape(ShapeType.CIRCLE);
						break;
					case 2:
						screen.deleteAllShape(ShapeType.TRIANGLE);
						break;
					case 3:
						screen.deleteAllShape(ShapeType.SQUARE);
						break;
					case 4:
						screen.deleteAllShape(ShapeType.RECTANGLE);
						break;
					case 5:
						screen.deleteAllShape(ShapeType.POLYGON);
						break;
					}
					System.out.println("Shapes deleted successfully");
				} else {
					System.out.println("Invalid Input");
				}

				break;
			case 4:
				System.out.println("1]Based on area");
				System.out.println("2]Based on perimeter");
				System.out.println("3]Based on distance from origin");
				System.out.println("4]Based on creation");
				int sortchoice = readIntFromConsel();
				if (sortchoice >= 1 && sortchoice <= 4) {
					switch (sortchoice) {
					case 1:
						screen.sortShapes(sortBase.AREA);
						break;
					case 2:
						screen.sortShapes(sortBase.PERIMETER);
						break;
					case 3:
						screen.sortShapes(sortBase.ORIGINDISTANCE);
						break;
					case 4:
						screen.sortShapes(sortBase.TIMESTAMP);
						break;
					}
					System.out.println("Shapes sorted successfully");
				} else {
					System.out.println("Invalid Input");
				}

				break;
			case 5:
				ArrayList<Shape> allshapeList = screen.getShapes();
				showShapes(allshapeList);
				break;
			case 6:
				System.out.print("Enter x coordinate");
				int x = readIntFromConsel();
				System.out.print("Enter y coordinate");
				int y = readIntFromConsel();
				ArrayList<Shape> enclosedShapes = screen
						.getEnclosingShapes(new Point(x, y));
				showShapes(enclosedShapes);
				break;
			case 7:
				return;
			}
		}
	}

	private static void showShapes(ArrayList<Shape> shapeList) {
		for (int index = 0; index < shapeList.size(); index++) {
			System.out.println((index + 1) + "] " + shapeList.get(index));
		}

	}

	private static Shape createShape() {
		int width;
		int height;
		int radius;
		int side;
		int x;
		int y;
		Point originPoint;
		Shape shape = null;
		ArrayList<Integer> parameters = new ArrayList<Integer>();
		System.out.println("1]Rectangle");
		System.out.println("2]Triangle");
		System.out.println("3]Circle");
		System.out.println("4]Square");
		System.out.println("5]Polygon");
		int shapechoice = readIntFromConsel();
		if (shapechoice >= 1 && shapechoice <= 5) {
			System.out.println("Enter x cordinate");
			x = readIntFromConsel();
			System.out.println("Enter y cordinate");
			y = readIntFromConsel();
			originPoint = new Point(x, y);
			switch (shapechoice) {
			case 1:
				System.out.println("Enter width");
				width = readIntFromConsel();
				System.out.println("Enter height");
				height = readIntFromConsel();
				parameters.add(width);
				parameters.add(height);
				shape = ShapeFactory.createShape(ShapeType.RECTANGLE,
						originPoint, parameters);
				break;
			case 2:
				System.out.println("Enter width");
				width = readIntFromConsel();
				System.out.println("Enter height");
				height = readIntFromConsel();
				parameters.add(width);
				parameters.add(height);
				shape = ShapeFactory.createShape(ShapeType.TRIANGLE,
						originPoint, parameters);
				break;
			case 3:
				System.out.println("Enter radius");
				radius = readIntFromConsel();
				parameters.add(radius);
				shape = ShapeFactory.createShape(ShapeType.CIRCLE, originPoint,
						parameters);
				break;
			case 4:
				System.out.println("Enter width");
				width = readIntFromConsel();
				parameters.add(width);
				shape = ShapeFactory.createShape(ShapeType.SQUARE, originPoint,
						parameters);

				break;
			case 5:
				System.out.println("Enter total number of sides :");
				int numberofsides = readIntFromConsel();
				System.out.println("Enter side length");
				side = readIntFromConsel();
				parameters.add(numberofsides);
				parameters.add(side);
				shape = ShapeFactory.createShape(ShapeType.POLYGON,
						originPoint, parameters);
				break;
			}

		} else {
			System.out.println("Invalid Input");
		}
		return shape;
	}
}
