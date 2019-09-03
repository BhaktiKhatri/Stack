package Stack;

import java.util.Arrays;
import java.util.Stack;

/*
 * 503. Next Greater Element II
 * https://leetcode.com/problems/next-greater-element-ii/
 * Given a circular array (the next element of the last element is the first element of the array), print the Next Greater Number for every element. The Next Greater Number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, output -1 for this number.
 * Example 1: Input: [1,2,1]; Output: [2,-1,2]
 * Explanation: The first 1's next greater number is 2; The number 2 can't find next greater number; The second 1's next greater number needs to search circularly, which is also 2.
 * Code and Explanation from: @yuxiangmusic https://leetcode.com/problems/next-greater-element-ii/discuss/98273/Java-10-lines-and-C%2B%2B-12-lines-linear-time-complexity-O(n)-with-explanation
 * Approach 3:https://leetcode.com/problems/next-greater-element-ii/solution/
 * Time complexity : O(n) Only two traversals of the nums array are done. Further, at most 2n elements are pushed and popped from the stack
 * Space complexity : O(n) A stack of size n is used. res array of size n is used
 */

public class NextGreaterElement2 {

	public static int[] nextGreaterElements(int[] nums) {
		int n = nums.length;
		System.out.println("nums: "+Arrays.toString(nums)+" n: "+n);
		
		int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<n; i++) {
            res[i] = -1;
        }
        
        for(int i=0; i<n * 2; i++) {
        	System.out.println("i: "+i+" i % n: "+(i % n)+" nums[i % n]: "+nums[i % n]);
            
        	int num = nums[i % n]; 
        	System.out.println("num: "+num+" stack: "+stack+" res: "+Arrays.toString(res));
            
        	while(!stack.isEmpty() && nums[stack.peek()] < num) {
            	res[stack.pop()] = num;
            }
            System.out.println("i: "+i+" n: "+n+" stack: "+stack+" res: "+Arrays.toString(res));
        	
        	if(i < n) { 
            	stack.push(i);
            }
        }
        System.out.println("res: "+Arrays.toString(res)+" stack: "+stack);
        return res;
    }
	
	public static void main(String[] args) {
		int[] nums = {3,8,4,1,2,3};
		nums = nextGreaterElements(nums);
		System.out.println("nums: "+Arrays.toString(nums));
	}

}
