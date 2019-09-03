package Stack;

import java.util.Stack;

/*
 * 232. Implement Queue using Stacks
 * https://leetcode.com/problems/implement-queue-using-stacks/description/
 * Implement the following operations of a queue using stacks.
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 * Example: MyQueue queue = new MyQueue();
 * queue.push(1); 
 * queue.push(2);  
 * queue.peek();  // returns 1
 * queue.pop();   // returns 1
 * queue.empty(); // returns false
 * Notes: You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
 * Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue),
 * as long as you use only standard operations of a stack. You may assume that all operations are valid (for example, no pop or peek operations
 * will be called on an empty queue).
 * Explanation and Code from: @StefanPochmann https://leetcode.com/problems/implement-queue-using-stacks/discuss/64206/Short-O(1)-amortized-C++-Java-Ruby
 * Appoach #2 https://leetcode.com/problems/implement-queue-using-stacks/solution/
 * Microsoft, Bloomberg
 * Easy
 */

public class ImplementQueueUsingStacks {

	Stack<Integer> input = new Stack<Integer>();
    Stack<Integer> output = new Stack<Integer>();
    
    /*
     * The newly arrived element is always added on top of stack s1 and the first element is kept as front queue element
     * Time complexity : O(1)
     * Space complexity : O(n) We need additional memory to store the queue elements
     */
    public void push(int x) {
    	System.out.println("x: "+x+" input: "+input);
        input.push(x);
    }

    /*
     * We have to remove element in front of the queue. This is the first inserted element in the stack s1 and it is positioned at the bottom of the stack
     * because of stack's LIFO (last in - first out) policy. To remove the bottom element from s1, we have to pop all elements from s1 and to push them on
     * to an additional stack s2, which helps us to store the elements of s1 in reversed order. This way the bottom element of s1 will be positioned on top
     * of s2 and we can simply pop it from stack s2. Once s2 is empty, the algorithm transfer data from s1 to s2 again.
     * Time complexity: Amortized O(1), Worst-case O(n); Amortized analysis gives the average performance (over time) of each operation in the worst case.
     * Space complexity : O(1)
     */
    public void pop() {
        peek();
        output.pop();
        System.out.println("output: "+output);
    }

    /*
     * The front element is kept in constant memory and is modified when we push an element. When s2 is not empty, front element is positioned on the top
     * of output
     * Get the front element
     * Time complexity: O(1); The front element was either previously calculated or returned as a top element of stack output. Therefore complexity is O(1)
     * Space complexity: O(1)
     */
    public int peek() {
    	System.out.println("input: "+input+" output: "+output);
    	
    	if(output.empty()) {
            while(!input.empty()) {
                output.push(input.pop());
            }
        }
    	System.out.println("input: "+input+" output: "+output);
        return output.peek();
    }

    //Both stacks input and output contain all stack elements, so the algorithm checks s1 and s2 size to return if the queue is empty.
    //Time complexity: O(1)
    //Space complexity: O(1)
    public boolean empty() {
    	System.out.println("input: "+input+" output: "+output);
        return input.empty() && output.empty();
    }
	
	public static void main(String[] args) {
		ImplementQueueUsingStacks stack = new ImplementQueueUsingStacks();
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		System.out.println(stack.peek());
		stack.pop();
	}

}
