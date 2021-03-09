package Factory;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestFactory {
	Screen screen = new Screen();

	@Test
	public void testCircle() {
		Point pt = new Point(10, 10);
		Shape circle = new Circle(pt, 10);
		assertEquals(314.1592, circle.getArea(),0.1);
		assertEquals(62.83, circle.getPerimeter(),0.1);
		assertEquals(true, circle.isPointEnclosed(new Point(5,5)));
		assertEquals(false, circle.isPointEnclosed(new Point(20,5)));
	}
	
	@Test
	public void testRectangle() {
		Point pt = new Point(10, 10);
		Shape rectangle = new Rectangle(pt, 10,10);
		assertEquals(100.00, rectangle.getArea(),0.1);
		assertEquals(40.00, rectangle.getPerimeter(),0.1);
		assertEquals(true, rectangle.isPointEnclosed(new Point(15,15)));
		assertEquals(false, rectangle.isPointEnclosed(new Point(30,5)));
	}
	
	@Test
	public void testSquare() {
		Point pt = new Point(10, 10);
		Shape square = new Square(pt, 10);
		assertEquals(100.00, square.getArea(),0.1);
		assertEquals(40.00, square.getPerimeter(),0.1);
		assertEquals(true, square.isPointEnclosed(new Point(15,15)));
		assertEquals(false, square.isPointEnclosed(new Point(30,5)));
	}
	
	@Test
	public void testTriangle() {
		Point pt = new Point(10, 10);
		Shape triangle = new Triangle(pt, 10,5);
		assertEquals(25, triangle.getArea(),0.1);
		assertEquals(true, triangle.isPointEnclosed(new Point(13,12)));
		assertEquals(false, triangle.isPointEnclosed(new Point(80,5)));
	}
	

	
}
