package Stack;

import java.util.Stack;

public class BasicCalculator {

	public static int calculate(String s) {
	    if(s == null) 
	    	return 0;
	        
	    System.out.println("s: "+s+" s.len: "+s.length());
	    
	    int result = 0;
	    int sign = 1;
	    int num = 0;
	            
	    Stack<Integer> stack = new Stack<Integer>();
	    stack.push(sign);
	            
	    for(int i=0; i<s.length(); i++) {
	        char c = s.charAt(i);
	        System.out.println("i: "+i+" c: "+c+" stack: "+stack+" result: "+result+" sign: "+sign+" num: "+num);
	                
	        if(c >= '0' && c <= '9') {
	            num = num * 10 + (c - '0');
	                    
	        } 
	        else if(c == '+' || c == '-') {
	            result = result + sign * num;
	            sign = stack.peek() * (c == '+' ? 1: -1); 
	            num = 0;
	        } 
	        else if(c == '(') {
	            stack.push(sign);
	                    
	        } 
	        else if(c == ')') {
	            stack.pop();
	        }
	    }
	    System.out.println("result: "+result+" sign: "+sign+" num: "+num+" stack: "+stack);        
	    
	    result = result + sign * num;
	    return result;
	}

	public static void main(String[] args) {
		String s = "(1+(4+5+2)-3)+(6+8)"; //" 2-1 + 2 ";
		System.out.println(calculate(s));
	}
}