package Specification;

import static org.junit.Assert.*;

import org.junit.Test;

public class SpecificationTesting {

	@Test
	public void testStringOperationCompare() {
		String firstInput = null;
		String secondInput = null;
		assertEquals(1, StringOperation.compare(firstInput, secondInput));

		firstInput = "hello world";
		secondInput = "hello world";
		assertEquals(1, StringOperation.compare(firstInput, secondInput));

		firstInput = "hello world";
		secondInput = "bye world";
		assertEquals(0, StringOperation.compare(firstInput, secondInput));

		firstInput = "";
		secondInput = "";
		assertEquals(1, StringOperation.compare(firstInput, secondInput));
	}

	@Test
	public void testStringOperationChangeCase() {
		String firstInput = null;
		assertEquals(null, StringOperation.changeCase(firstInput));

		firstInput = "Hello World a123#b A789#B";
		assertEquals("hELLO wORLD A123#B a789#b",
				StringOperation.changeCase(firstInput));

		firstInput = "";
		assertEquals("", StringOperation.changeCase(firstInput));
	}

	@Test
	public void testStringOperationGetReverse() {
		String firstInput = null;
		assertEquals(null, StringOperation.getReverse(firstInput));

		firstInput = "Hello World";
		assertEquals("dlroW olleH", StringOperation.getReverse(firstInput));

		firstInput = "";
		assertEquals("", StringOperation.getReverse(firstInput));
	}

	@Test
	public void testStringOperationFindLongest() {
		String firstInput = null;
		assertEquals(null, StringOperation.findLongest(firstInput));

		firstInput = "hey whats your name";
		assertEquals("whats", StringOperation.findLongest(firstInput));

		firstInput = "";
		assertEquals("", StringOperation.findLongest(firstInput));
	}

	@Test
	public void testAreaCicleArea() {
		float radius = 10.0f;
		assertEquals(314.16, Area.circleArea(radius), 0.0001);
	}

	@Test
	public void testAreaRectangle() {
		float height = 10.0f;
		float width = 12.0f;
		assertEquals(120.00, Area.rectangleArea(width, height), 0.0001);
	}

	@Test
	public void testAreaCicleSquare() {
		float width = 12.0f;
		assertEquals(144.00, Area.squareArea(width), 0.0001);
	}

	@Test
	public void testAreaTriangleArea() {
		float height = 10.0f;
		float width = 12.0f;
		assertEquals(60.0, Area.triangleArea(width, height), 0.0001);
	}

	@Test
	public void testMarksheet() {
		int grades[] = { 80, 90, 100, 39, 40, 38, 67, 30, 60, 60 };
		int studentCount = grades.length;
		Marksheet marksheet = new Marksheet(studentCount, grades);
		assertEquals(100, marksheet.maximum());
		assertEquals(30, marksheet.mainimum());
		assertEquals(60.4, marksheet.average(), 0.0001);
		assertEquals(70.0, marksheet.studentPassPercentage(), 0.0001);

	}

}