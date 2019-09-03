package Stack;

import java.util.Stack;

public class MinStack {
   
    Stack<Integer> stack = new Stack<>();
    int min = Integer.MAX_VALUE;

    public void push(int x) {
    	System.out.println("x: "+x+" min: "+min+" stack: "+stack);
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
    	System.out.println("min: "+min+" stack: "+stack);
        int peek = stack.pop();
        
        System.out.println("peek: "+peek);
        
        if(peek == min) {
            min = stack.pop();
        }
    }

    public int top() {
    	System.out.println("min: "+min+" stack: "+stack);
        return stack.peek();
    }

    public int getMin() {
    	System.out.println("min: "+min+" stack: "+stack);
        return min;
    }
    
    public static void main(String[] args) {
		MinStack minStack = new MinStack();
		
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		minStack.getMin();    //Returns -3.
		minStack.pop();
		minStack.top();      // Returns 0.
		minStack.getMin();   // Returns -2.
	}

}