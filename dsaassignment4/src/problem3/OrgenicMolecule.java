package problem3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * This class provide facelity to calculate molecule compounds.
 * 
 * @author anuj.khandelwal_meta
 *
 */
public class OrgenicMolecule {
	/**
	 * 
	 * @param atom
	 *            name of molecule
	 * @return int molecule weight of single molecule
	 */
	public int getAtomicWeight(String atom) {
		int atomicWeight = 0;
		switch (atom) {
		case "C":
			atomicWeight = 12;
			break;
		case "O":
			atomicWeight = 16;
			break;
		case "H":
			atomicWeight = 1;
			break;
		}
		return atomicWeight;
	}

	/**
	 * this function is used to calculate compound molecule weight.
	 * 
	 * @param compound
	 *            compound molecule formula whose weight to be calculate.
	 * @return molecule weight of compound molecule.
	 */
	int calculateCompoundWeight(String compound) {
		int compoundWeight = 0;
		// making token of compound molecule formula
		List<String> compoundTokens = getToken(compound);
		int index = 0;
		// stack is used to calculate molecule weight of compound molecule.
		Stack<String> molecularWeightStack = new Stack<String>();
		// iteration until compound Tokens available
		while (index < compoundTokens.size()) {
			String compoundToken = compoundTokens.get(index);
			index++;
			// if left parenthesis found push it on stack;
			if (compoundToken.equals("(")) {
				molecularWeightStack.push(compoundToken);
			}
			// if right parenthesis found pop until left parenthesis found.
			else if (compoundToken.equals(")")) {
				int Molsum = 0;
				// sum molecule weight of sub formula.
				while (!molecularWeightStack.peek().equals("(")) {
					Molsum += Integer.parseInt(molecularWeightStack.pop());
				}
				molecularWeightStack.pop();
				molecularWeightStack.push(String.valueOf(Molsum));

			}
			// if molecule found push it's weight on stack.
			else if (compoundToken.equals("C") || compoundToken.equals("O")
					|| compoundToken.equals("H")) {
				String moleCuleWeight = String
						.valueOf(getAtomicWeight(compoundToken));
				molecularWeightStack.push(moleCuleWeight);
			}
			// if molecule count in formula found multiply it with top stack
			// number and push on stack.
			else if (isNumber(compoundToken)) {
				int stackTop = Integer.parseInt(molecularWeightStack.pop());
				String moleCuleWeight = String.valueOf(stackTop
						* Integer.parseInt(compoundToken));
				molecularWeightStack.push(moleCuleWeight);
			}

		}

		// pop until stack has elements and add weight to get molecularWeight.
		while (!molecularWeightStack.isEmpty()) {
			compoundWeight += Integer.parseInt(molecularWeightStack.pop());
		}
		return compoundWeight;
	}

	/**
	 * Split the compound formula and return list of compound formula's token
	 * 
	 * @param compound
	 *            compound formula to be split.
	 * @return List of compound formula's token
	 */
	private List<String> getToken(String compound) {
		ArrayList<String> compoundTokens = new ArrayList<String>();
		// check for compound string is null or not
		if (compound != null) {
			// iteration over compound formula string
			for (int index = 0; index < compound.length(); index++) {
				// if current character is integer
				if (Character.isDigit(compound.charAt(index))) {
					String number = new String();
					// getting whole number by concatenating number characters
					while (index < compound.length()
							&& Character.isDigit(compound.charAt(index))) {
						number += compound.charAt(index);
						index++;
					}
					index--;
					compoundTokens.add(number);

				}// if current character is not integer
				else {
					compoundTokens.add(String.valueOf(compound.charAt(index)));
				}
			}
		}
		return compoundTokens;
	}

	/**
	 * This function determine a string is number or not
	 * 
	 * @param compoundToken
	 *            String token which to be checked for number
	 * @return boolean true if string compoundToken is number else false.
	 */
	private boolean isNumber(String compoundToken) {
		try {
			Integer.parseInt(compoundToken);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
