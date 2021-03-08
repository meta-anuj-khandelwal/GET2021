package question1;

import static org.junit.Assert.*;

import org.junit.Test;

public class InfixTest {
	InfixCalc infixCalc;

	/**
	 * Junit test for infix expression evaluation
	 */
	@Test
	public void test() {
		// addition case
		infixCalc = new InfixCalc("1 + 2");
		assertEquals(3, infixCalc.evaluate());

		// relational operator case
		infixCalc = new InfixCalc("5 > 2");
		assertEquals(1, infixCalc.evaluate());

		// relational operator case
		infixCalc = new InfixCalc("21 < 23");
		assertEquals(1, infixCalc.evaluate());

		// Complex mathematical operation
		infixCalc = new InfixCalc(
				"( 5 * 8 ) / 4 - -2 * ( 2 + 4 / 4 * ( 2 - 21 ) )");
		assertEquals(-24, infixCalc.evaluate());

		infixCalc = new InfixCalc("1 + 2 * 3 - 4");
		assertEquals(3, infixCalc.evaluate());

		// logical operation
		infixCalc = new InfixCalc("0 && 2");
		assertEquals(0, infixCalc.evaluate());

		// logical operation
		infixCalc = new InfixCalc("1 || 2");
		assertEquals(1, infixCalc.evaluate());
	}

}
