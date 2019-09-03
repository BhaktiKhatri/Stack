package Stack;

import java.util.Stack;
import Stack.TreeNode;

/*
 * 173. Binary Search Tree Iterator
 * https://leetcode.com/problems/binary-search-tree-iterator/description/
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 * Explanation and Code from: @xcv58 https://leetcode.com/problems/binary-search-tree-iterator/discuss/52525/My-solutions-in-3-languages-with-Stack
 * Microsoft, Google, Facebook, LinkedIn
 * Medium
 */

public class BinarySearchTreeIterator {

	public Stack<TreeNode> stack = new Stack<TreeNode>();
	TreeNode root;
	
	/*
	 * I use Stack to store directed left children from root. When next() be called, I just pop one element and process its right child as new root.
	 * The code is pretty straightforward. So this can satisfy O(h) memory, hasNext() in O(1) time, next() is O(1) time.
	 * The average time complexity of next() function is O(1) indeed in your case. As the next function can be called n times at most, and the number of
	 * right nodes in self.pushAll(tmpNode.right) function is maximal n in a tree which has n nodes, so the amortized time complexity is O(1).
	 */
	
	public BinarySearchTreeIterator(TreeNode root) {
		//pushAll(root);
	}
	
	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !stack.isEmpty();
	}
	
	/** @return the next smallest number */
	public int next() {
		TreeNode tempNode = stack.pop();
		System.out.println("tempNode: "+tempNode.val);
		pushAll(tempNode.right);
		return tempNode.val;
	}
	
	public void pushAll(TreeNode root) {
		//for(; root != null; stack.push(root), root = root.left);
		
		while(root != null) {
			System.out.println("root: "+root.val);
        
			stack.push(root);
            root = root.left;
        }
	}
	
	public static void main(String[] args) {
		BinarySearchTreeIterator tree = new BinarySearchTreeIterator(new TreeNode(20));
		/*
						    7						
						  /   \
						 3     15
						      / \
						     9  20
		*/
		
		tree.root = new TreeNode(7);
		tree.root.left = new TreeNode(3);
		tree.root.right = new TreeNode(15);
		tree.root.right.right = new TreeNode(20);
		tree.root.right.left = new TreeNode(9);

		tree.pushAll(tree.root);
		System.out.println(tree.next());    // return 3
		System.out.println(tree.next());    // return 7
		System.out.println(tree.hasNext()); // return true
		System.out.println(tree.next());    // return 9
		System.out.println(tree.hasNext()); // return true
		System.out.println(tree.next());    // return 15
		System.out.println(tree.hasNext()); // return true
		System.out.println(tree.next());    // return 20
		System.out.println(tree.hasNext()); // return false
	}
}