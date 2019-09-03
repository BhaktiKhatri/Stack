package Stack;

import java.util.Stack;

/**
 * Leetcode 20. Valid Parentheses
 * https://leetcode.com/problems/valid-parentheses/description/
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * Explanation and Code from: https://leetcode.com/problems/valid-parentheses/discuss/9178
 * @author NisuBhakti
 * Time Complexity: O(N)
 * Easy
 * Google, Facebook, Microsoft, Amazon, Bloomberg, Twitter, Airbnb, Zenefits
 */

public class ValidParentheses {

	public static boolean isValid(String s) {
		if(s.length() % 2 == 1)	//if s has odd length then return false
			return false;
		
		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if (c == '(')
				stack.push(')');
			else if (c == '{')
				stack.push('}');
			else if (c == '[')
				stack.push(']');
			else if (stack.isEmpty() || stack.pop() != c)
				return false;
		}
		return stack.isEmpty();
	}
	
	public static void main(String[] args) {
		String s = "([}]";
		System.out.println(isValid(s));
	}

}
