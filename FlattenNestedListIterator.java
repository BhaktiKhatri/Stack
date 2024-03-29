package Stack;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/*
 * 341. Flatten Nested List Iterator
 * https://leetcode.com/problems/flatten-nested-list-iterator/description/
 * Given a nested list of integers, implement an iterator to flatten it.
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 * Example 1: Given the list [[1,1],2,[1,1]],
 * By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].
 * Example 2: Given the list [1,[4,[6]]],
 * By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].
 * Explanation and Code from: @FreeTymeKiyan https://leetcode.com/problems/flatten-nested-list-iterator/discuss/80147/Simple-Java-solution-using-a-stack-with-explanation
 */

	// This is the interface that allows for creating nested lists.
	// You should not implement it, or speculate about its implementation
interface NestedInteger {
 
      // @return true if this NestedInteger holds a single integer, rather than a nested list.
      public boolean isInteger();
 
      // @return the single integer that this NestedInteger holds, if it holds a single integer
      // Return null if this NestedInteger holds a nested list
      public Integer getInteger();
 
      // @return the nested list that this NestedInteger holds, if it holds a nested list
      // Return null if this NestedInteger holds a single integer
      public List<NestedInteger> getList();
  }
 
/*
 	In the constructor, we push all the nestedList into the stack from back to front, so when we pop the stack, it returns the very first element. 
 	Second, in the hasNext() function, we peek the first element in stack currently, and if it is an Integer, we will return true and pop the element. 
 	If it is a list, we will further flatten it. This is iterative version of flatting the nested list. Again, we need to iterate from the back to front of the
 	list.
 */
public class FlattenNestedListIterator  implements Iterator<Integer> {

    private Stack<NestedInteger> stack;
	
    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        flattenList(nestedList);
    }
    
	@Override
	public boolean hasNext() {
		while (!stack.isEmpty()) {
            if (stack.peek().isInteger()) 
            	return true;
            flattenList(stack.pop().getList());
        }
        return false;	
    }

	@Override
	public Integer next() {
        return hasNext() ? stack.pop().getInteger() : null;
	}
	
	public void flattenList(List<NestedInteger> list) {
        for(int i = list.size() - 1; i >= 0; i--) {
            stack.push(list.get(i));
        }
    }
	
	public static void main(String[] args) {

	}

}
