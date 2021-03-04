package dsaassignment1;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestAssignment {
	@Test
	// test for list rotation function
	public void testRotaion() {
		MyLinkList<Integer> list = new MyLinkList<Integer>();
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);

		list.rotateSublist(2, 5, 2);
		int arr[] = list.toArray();
		int solution[] = { 2, 5, 6, 3, 4, 7 };
		assertEquals(arr[0], solution[0]);
		assertEquals(arr[1], solution[1]);
		assertEquals(arr[2], solution[2]);
		assertEquals(arr[3], solution[3]);
		assertEquals(arr[4], solution[4]);
		assertEquals(arr[5], solution[5]);

	}

	@Test
	public void testLoopList() {
		// test case 1
		MyLinkList<Integer> list = new MyLinkList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.getStart().getNext().getNext().getNext().getNext()
				.setNext(list.getStart().getNext());

		assertEquals(true, list.isLoop());

		// test case 2
		MyLinkList<Integer> list1 = new MyLinkList<Integer>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		list1.add(5);

		assertEquals(false, list1.isLoop());
	}

	@Test
	public void testPolynomial() {
		// assume equation -> 5x^2y^2 + 3x^2y^6 + 20
		// degree will be 2+6=8
		MyLinkList<MyLinkList<Integer>> polynomial = new MyLinkList<MyLinkList<Integer>>();
		// adding total terms in polynomial
		polynomial.add(new MyLinkList<Integer>());
		polynomial.add(new MyLinkList<Integer>());
		polynomial.add(new MyLinkList<Integer>());

		// assume polynomial has 2 variables
		polynomial.get(0).add(2);
		polynomial.get(0).add(2);
		polynomial.get(0).add(5);
		polynomial.get(1).add(2);
		polynomial.get(1).add(6);
		polynomial.get(1).add(4);
		polynomial.get(2).add(20);

		assertEquals(8, Polynomial.getPolyDegree(polynomial));
	}

}
