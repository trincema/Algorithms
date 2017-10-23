package alg.ds.linear;

/**
 * @author Emanuel TRÎNC
 * Generic Linked list implementation of the 'Stack' data structure.
 * Advantages: 
 * Disadvantages: 
 * Space complexity: O(2N)
 * Time complexity:
 * 		- insert: O(1)
 * 		- get: O(1)
 * 		- search: O(1)
 * 		- delete: O(1)
 */
public class Stack<Item> {
	private Node<Item> top;
	
	/**
	 * Method to push data on the top of the stack.
	 * @param item The item to be pushed on the stack.
	 */
	public void push(Item item) {
		Node<Item> node = new Node<>(item);
		if (isEmpty()) {	// Put the item directly in the top variable if the stack is empty
			top = node;
		} else {			// 
			node.next = top;
			top = node;
		}
	}
	
	/**
	 * Method to return and remove the last element on the stack.
	 * @return Last item pushed on the stack.
	 */
	public Item pop() {
		Item item = top.item;
		top = top.next;
		return item;
	}
	
	/**
	 * Method to retrieve without deletion the last element on the stack.
	 * @return The last item pushed on the stack.
	 */
	public Item peek() {
		return top.item;
	}
	
	/**
	 * Method to check if the stack is empty.
	 * @return true is the stack is empty, false otherwise.
	 */
	public boolean isEmpty() {
		return top == null;
	}
	
	/**
	 * Method used to clear the stack.
	 */
	public void clear() {
		top = null;
	}
	
	/**
	 * Node class, used to link the stack elements.
	 */
	private class Node<T> {
		public Node<T> next;
		public Item item;
		
		public Node(Item item) {
			this.item = item;
		}
	}

}
