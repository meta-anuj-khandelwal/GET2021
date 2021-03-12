package problem2;

import static org.junit.Assert.*;

import org.junit.Test;

public class PrirityQueueTest {

	@Test
	public void test() {
		Node<Integer> node;
		PriorityQueue<Node> queue = new MyPriorityQueue(6);
		// Insertion of different number of different priority
		node = new Node<Integer>(4);
		assertEquals(true, queue.enQueue(node));
		node = new Node<Integer>(-21);
		assertEquals(true, queue.enQueue(node));
		node = new Node<Integer>(123);
		assertEquals(true, queue.enQueue(node));
		node = new Node<Integer>(0);
		assertEquals(true, queue.enQueue(node));
		node = new Node<Integer>(-12);
		assertEquals(true, queue.enQueue(node));
		node = new Node<Integer>(400);
		assertEquals(true, queue.enQueue(node));
		node = new Node<Integer>(4123);
		// overflow condition
		assertEquals(false, queue.enQueue(node));

		// dequeue as per priority
		assertEquals(400, queue.deQueue().getData());
		assertEquals(123, queue.deQueue().getData());
		assertEquals(4, queue.deQueue().getData());
		assertEquals(0, queue.deQueue().getData());
		assertEquals(-12, queue.deQueue().getData());
		assertEquals(-21, queue.deQueue().getData());
		// underflow condition
		assertEquals(null, queue.deQueue());

	}
}
