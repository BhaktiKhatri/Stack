package Stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 	150. Evaluate Reverse Polish Notation
	https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
	Evaluate the value of an arithmetic expression in Reverse Polish Notation.
	Valid operators are +, -, *, /. Each operand may be an integer or another expression.
	Some examples:
	  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
	  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
	Explanation and Code from: EPI book
	LinkedIn
	Medium
*/
public class EvaluateRPNExpressions {

	public static int eval(String RPNExpression) {
		if(RPNExpression.length() == 0)
			return 0;
		
		System.out.println("RPNExpression: "+RPNExpression);
		Deque<Integer> intermediateResults = new ArrayDeque<>();		//LIFO
		String delimeter = ",";
		String[] symbols = RPNExpression.split(delimeter);
		System.out.println("symbols: "+Arrays.toString(symbols));
		
		for(String token: symbols) {
			System.out.println("token: "+token);
			
			if(token.length() == 1 && "+-*/".contains(token)) {
				
				final int y = intermediateResults.removeFirst();
				final int x = intermediateResults.removeFirst();
				System.out.println("y: "+y+" x: "+x+" token.charAt(0): "+token.charAt(0));
				
				switch(token.charAt(0)) {
				case '+':
					intermediateResults.addFirst(x + y);
					break;
				case '-':
					intermediateResults.addFirst(x - y);
					break;
				case '*':
					intermediateResults.addFirst(x * y);
					break;
				case '/':
					intermediateResults.addFirst(x / y);
					break;
				default:
					throw new IllegalArgumentException("Malformed RPN at: "+token);
				}
			}
			else {	//token is a number
				System.out.println("token: "+token+" intermediateResults: "+intermediateResults);
				intermediateResults.addFirst(Integer.parseInt(token));
			}
		}
		return intermediateResults.removeFirst();
	} 
	
	
	/*
	 * if(y != 0) {
					    intermediateResults.add(x / y);
                        break;
                    }
                    else {
                        throw new ArithmeticException("Divide by 0 is not allowed!");    
                    } 
	 */
	
	//Refer this; EPI book question
	public static int evalRPN(String RPNExpression) {
		if(RPNExpression.length() == 0)
			return 0;
		
		System.out.println("RPNExpression: "+RPNExpression);
		Stack<Integer> intermediateResults = new Stack<>();		//LIFO
		String delimeter = ",";
		String[] symbols = RPNExpression.split(delimeter);
		System.out.println("symbols: "+Arrays.toString(symbols));
		
		for(String token: symbols) {
			System.out.println("token: "+token);
			
			if(token.length() == 1 && "+-*/".contains(token)) {
				System.out.println(intermediateResults);
				
				final int y = intermediateResults.pop();
				final int x = intermediateResults.pop();
				System.out.println("y: "+y+" x: "+x+" token.charAt(0): "+token.charAt(0));
				
				switch(token.charAt(0)) {
				case '+':
					intermediateResults.add(x + y);
					break;
				case '-':
					intermediateResults.add(x - y);
					break;
				case '*':
					intermediateResults.add(x * y);
					break;
				case '/':
					intermediateResults.add(x / y);
					break;
				default:
					throw new IllegalArgumentException("Malformed RPN at: "+token);
				}
			}
			else {	//token is a number
				System.out.println("token: "+token+" intermediateResults: "+intermediateResults);
				intermediateResults.add(Integer.parseInt(token));
			}
		}
		return intermediateResults.pop();
	}
	
	//Refer this; Leetcode question
	public static int evalRPN(String[] tokens) {
        if(tokens.length == 0) {
            return 0;
        }
        else if(tokens.length == 1) {
            return Integer.parseInt(tokens[0]);
        }
        System.out.println("tokens: "+Arrays.toString(tokens));
        
		Stack<Integer> stack = new Stack<>();		//LIFO
		
		for(String token: tokens) {
			System.out.println("token: "+token+" stack: "+stack);
			
			if(token.length() == 1 && "+-*/".contains(token)) {
				
				final int y = stack.pop();
				final int x = stack.pop();
				System.out.println("y: "+y+" x: "+x);
				
				switch(token.charAt(0)) {
				case '+':
					stack.add(x + y);
					break;
				case '-':
					stack.add(x - y);
					break;
				case '*':
					stack.add(x * y);
					break;
				case '/':
					stack.add(x / y);
					break;
				default:
					throw new IllegalArgumentException("Malformed RPN at: "+token);
				}
			}
			else {	//token is a number
				stack.add(Integer.parseInt(token));
			}
		}
		return stack.pop();
    }
	
	public static void main(String[] args) {
		//String RPNExpression = "3,4,+,2,*,1,+";
		String RPNExpression = "4,13,5,/,+"; //"1,1,+,-2,*";"0,3,/"]
		//System.out.println("Result: "+evalRPN(RPNExpression));
		String[] tokens = {"2", "1", "+", "3", "*"};
		System.out.println("Result: "+evalRPN(tokens));
	}
}