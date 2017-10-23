package alg.ds.linear;

/**
 * @author Emanuel TRÎNC
 * Array implementation of the 'Stack' data structure.
 * Space complexity: O(N)
 * Time complexity:
 * 		- insert: O(1)
 * 		- get: O(1)
 * 		- search: O(1)
 * 		- delete: O(1)
 */
public class StackInt {
	private int[] items;
	private int index = 0;
	
	/**
	 * Constructor used to initialize the stack.
	 * @param elements The maximum number of stack elements.
	 */
	public StackInt(int elements) {
		items = new int[elements];
	}
	
	/**
	 * Method to push data on the top of the stack.
	 * @param item The item to be pushed on the stack.
	 */
	public void push(int item) {
		items[index] = item;
		index++;
	}
	
	/**
	 * Method to return and retrieve the last element on the stack.
	 * @return The last element on the stack.
	 */
	public int pop() {
		index--;
		return items[index];
	}
	
	/**
	 * Method to check if the stack is empty.
	 * @return true is the stack is empty, false otherwise.
	 */
	public boolean isEmpty() {
		return index == 0;
	}
	
	/**
	 * Method to check if the stack is full.
	 * @return true if the stack is full, false otherwise.
	 */
	public boolean isFull() {
		return index == items.length;
	}

}
