package problem3;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This is test class for OrgenicMolecule class
 * 
 * @author Anuj khandelwal
 *
 */
public class MolecularWeightTest {
	OrgenicMolecule molecule = new OrgenicMolecule();

	/**
	 * test cases single atom, compound structures , multiple digit atom count .
	 */
	@Test
	public void test() {
		assertEquals(46, molecule.calculateCompoundWeight("C(OH)2"));
		assertEquals(12, molecule.calculateCompoundWeight("C"));
		assertEquals(358, molecule.calculateCompoundWeight("C12H22O12"));
		assertEquals(86, molecule.calculateCompoundWeight("CHOC(CH3)3"));
	}

}
