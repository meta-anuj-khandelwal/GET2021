package question1;

import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * <h1>InfixCalc</h1>
 * <p>
 * This class is used to evaluate infix expression.
 * 
 * </p>
 * 
 * @author Anuj Khandelwal
 * @version 1.0
 * @since 2021-03-04
 */
public class InfixCalc {
	// stack to store operands
	Stack<Integer> operand = new OperandStack();
	// stack to store operators
	Stack<String> operator = new OperatorStack();
	// string store expression
	String expression = new String();
	StringTokenizer tokens;
	// store precedence of different operators.
	HashMap<String, Integer> precedenceMap = new HashMap<String, Integer>();

	/**
	 * @param expression
	 *            infix expression to calculated
	 */
	public InfixCalc(String expression) {
		this.expression = expression;
		// tokenizing expression string on space
		tokens = new StringTokenizer(expression, " ");
		// setting precedence for different operators
		precedenceMap.put("(", -1);
		precedenceMap.put(")", -1);
		precedenceMap.put("*", 3);
		precedenceMap.put("/", 3);
		precedenceMap.put("+", 2);
		precedenceMap.put("-", 2);
		precedenceMap.put("==", 1);
		precedenceMap.put("!=", 1);
		precedenceMap.put("<=", 1);
		precedenceMap.put("<", 1);
		precedenceMap.put(">=", 1);
		precedenceMap.put(">", 1);
		precedenceMap.put("&&", 0);
		precedenceMap.put("||", 0);
		precedenceMap.put("!", 0);
	}

	/**
	 * This function is used to evaluate infix expression
	 * 
	 * @return int solution of infix expression
	 */
	int evaluate() {
		int solution = 0;
		// Get the next token.
		while (tokens.hasMoreTokens()) {
			String token = tokens.nextToken();
			// System.out.println(token);
			int tokentype = tokenType(token);
			switch (tokentype) {
			case 1:
				// number
				int number = Integer.parseInt(token);
				operand.push(number);
				break;
			case 2:
				// operator
				while (operator.size() != 0
						&& precedenceMap.get(operator.peek()) >= precedenceMap
								.get(token)) {
					String operation = operator.pop();
					int num1 = operand.pop();
					int num2 = operand.pop();
					int result = calculate(operation, num1, num2);
					// System.out.println(result);
					operand.push(result);
				}
				// Push operator onto the operator stack
				operator.push(token);
				break;
			case 3:
				// left parenthesis
				operator.push(token);
				break;
			case 4:
				// right parenthesis
				while (!operator.peek().equals("(")) {
					String operation = operator.pop();
					int num1 = operand.pop();
					int num2 = operand.pop();
					int result = calculate(operation, num1, num2);
					operand.push(result);
				}
				// discarding left parenthesis
				operator.pop();

				break;
			default:
				break;
			}
		}
		// While the operator stack is not empty,
		while (operator.size() != 0) {
			String operation = operator.pop();
			int num1 = operand.pop();
			int num2 = operand.pop();
			int result = calculate(operation, num1, num2);
			operand.push(result);
		}
		if (operand.size() != 1) {
			throw new ArithmeticException("Invalid Expression");
		}

		if (operand.size() != 0)
			solution = operand.peek();
		else
			solution = 0;
		return solution;
	}

	/**
	 * 
	 * @param operation
	 *            String mathematical operation to be applied
	 * @param num1
	 *            int first number on which mathematical operation to be applied
	 * @param num2
	 *            int second number on which mathematical operation to be
	 *            applied
	 * @return int result of operation
	 */
	private int calculate(String operation, int num1, int num2) {
		int result = 0;
		switch (operation) {
		case "*":
			result = num2 * num1;
			break;
		case "/":
			result = num2 / num1;
			break;
		case "+":
			result = num2 + num1;
			break;
		case "-":
			result = num2 - num1;
			break;
		case "==":
			result = num2 == num1 ? 1 : 0;
			break;
		case "!=":
			result = num2 != num1 ? 1 : 0;
			break;
		case "<=":
			result = num2 <= num1 ? 1 : 0;
			break;
		case "<":
			result = num2 < num1 ? 1 : 0;
			break;
		case ">=":
			result = num2 >= num1 ? 1 : 0;
			break;
		case ">":
			result = num2 > num1 ? 1 : 0;
			break;
		case "&&":
			if (num2 == 0 || num1 == 0) {
				result = 0;
			} else {
				result = 1;
			}
			break;
		case "||":
			if (num2 == 0 && num1 == 0) {
				result = 0;
			} else {
				result = 1;
			}
			break;
		case "!":
			if (num2 != num1) {
				result = 1;
			} else {
				result = 0;
			}
			break;

		}
		return result;
	}

	/**
	 * This function is used find type of token ,type=1 means number ,type=2
	 * means operator ,type=3 means left parenthesis,type =4 means right
	 * parenthesis
	 * 
	 * @param token
	 *            String token
	 * @return int type of token
	 */

	private int tokenType(String token) {
		// type=1 means number ,type=2 means operator ,type=3 means left
		// parenthesis,type =4 means right parenthesis
		int type = -1;
		try {
			int number = Integer.parseInt(token);
			type = 1;
		} catch (NumberFormatException numberFormatException) {
		}
		if (precedenceMap.containsKey(token)
				&& !(token.equals("(") || token.equals(")"))) {
			type = 2;
		} else if (token.equals("(")) {
			type = 3;
		} else if (token.equals(")")) {
			type = 4;
		}
		return type;
	}
}
