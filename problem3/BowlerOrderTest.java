package problem3;

import static org.junit.Assert.*;

import org.junit.Test;

public class BowlerOrderTest {

	@Test
	public void test() {
		BowlerOrder bowlerOrder = new BowlerOrder(3);
		Bowler bowler = new Bowler("b1", 5);
		Bowler bowler1 = new Bowler("b2", 7);
		Bowler bowler2 = new Bowler("b3", 6);
		bowlerOrder.addBowler(bowler);
		bowlerOrder.addBowler(bowler1);
		bowlerOrder.addBowler(bowler2);
		assertEquals("b2b3b2b1b3b2b1b3b2b1b3b2b1b3", bowlerOrder.getOrder(14));
	}

}
