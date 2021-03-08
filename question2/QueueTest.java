package question2;

import static org.junit.Assert.*;

import org.junit.Test;

import question1.InfixCalc;

public class QueueTest {

	/**
	 * Test for circular queue
	 */
	@Test
	public void test() {
		Queue<Integer> queue = new circularQueue();
		// enqueue
		assertEquals(true, queue.enqueue(1));
		assertEquals(true, queue.enqueue(2));
		assertEquals(true, queue.enqueue(3));
		assertEquals(true, queue.enqueue(4));
		assertEquals(true, queue.enqueue(5));
		// enqueue when queue is full
		assertEquals(false, queue.enqueue(1));
		// dequeue
		assertEquals(new Integer(1), queue.dequeue());
		// enqueue after dequeue
		assertEquals(true, queue.enqueue(6));

	}

}
