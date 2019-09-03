package Stack;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueue {

	    private Queue<Integer> queue = new LinkedList<>();

	    public void push(int x) {
	    	System.out.println("x: "+x);
	        queue.add(x);
	        
	        System.out.println("queue: "+queue);
	        
	        for(int i=1; i<queue.size(); i++) {
	            queue.add(queue.remove());
	        }
	        
	        System.out.println("queue: "+queue);
	    }

	    public void pop() {
	    	System.out.println("queue: "+queue);
	        queue.remove();
	    }

	    public int top() {
	    	System.out.println("queue: "+queue);
	        return queue.peek();
	    }

	    public boolean empty() {
	    	System.out.println("queue: "+queue);
	        return queue.isEmpty();
	    }
	
	public static void main(String[] args) {
		ImplementStackUsingQueue stack = new ImplementStackUsingQueue();
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		System.out.println("top: "+stack.top());
		stack.pop();
		System.out.println(stack.empty());
	}
}