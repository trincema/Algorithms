package alg.ds.linear;

/**
 * @author Emanuel TRÎNC
 * Linked implementation of the 'SinglyLinkedList' data structure.
 * Space complexity: O(2N)
 * Time complexity:
 * 		- insert: O(N)
 * 		- get: O(N/2) on average
 * 		- search: O(N/2) on average
 * 		- delete: O(N/2) on average
 */
public class SinglyLinkedList<Element> {
	private Node<Element> head;
	private int size = 0;
	
	public SinglyLinkedList() {}
	
	/**
	 * Appends the specified element to the end of this list.
	 * @param element The element to be appended to the list.
	 * @return true if this collection was changed as a result of the call.
	 * @throws NullPointerException If the specified element is null.
	 */
	public boolean add(Element element) throws NullPointerException {
		if (element == null) {
			throw new NullPointerException("Cannot add a null element to the list");
		}
		Node<Element> node = new Node<>(element);
		if (isEmpty()) {
			// Put the new node in the head of the list if empty
			head = node;
		} else {
			// Add the new node at the back of the list
			Node<Element> current = head;
			while (current.next != null) {
				current = current.next;
			}
			// After the while, the 'current' variable contains the reference of the last node
			current.next = node;
		}
		size++;
		return true;
	}
	
	/**
	 * Inserts the specified element at the specified position in this list.
	 * Shifts the element already at that position (if any), and any subsequent elements to the right.
	 * @param index The index at which the specified element is to be inserted.
	 * @param element The element to be inserted.
	 * @return true if this collection was changed as a result of the call.
	 * @throws NullPointerException If the specified element is null.
	 * @throws IndexOutOfBoundsException If index is out of range.
	 */
	public boolean add(int index, Element element) throws NullPointerException, IndexOutOfBoundsException {
		if (element == null) {
			throw new NullPointerException("Cannot add a null element to the list");
		}
		if (index >= 0 && index < size) {
			Node<Element> node = new Node<>(element);
			if (index == 0) {
				// Add the node to the head of the list
				node.next = head;
				head = node;
			} else if (index == size) {
				// Add the element to the back of the list
				return add(element);
			} else {
				// Iterate to the required index
				Node<Element> current = head;
				Node<Element> previous = null;
				for (int i = 0; i < index; i++) {
					previous = current;
					current = current.next;
				}
				previous.next = node;
				node.next = current;
			}
			size++;
			return true;
		} else {
			throw new IndexOutOfBoundsException("Index " + index + " out of range");
		}
	}
	
	/**
	 * Returns the element at the specified position in this list.
	 * @param index The index of the element to return.
	 * @return The element at the specified position.
	 * @throws IndexOutOfBoundException if index is out of range.
	 */
	public Element get(int index) throws IndexOutOfBoundsException {
		// First, check if the index is valid
		if (index >= 0 && index < size) {
			// Navigate to the required element.
			Node<Element> current = head;
			for (int i = 0; i < index; i++) {
				current = current.next;
			}
			return current.element;
		} else {
			throw new IndexOutOfBoundsException("Index " + index + " out of range");
		}
	}
	
	/**
	 * Returns true if this list contains at least one element equal to the given element.
	 * @param element Element whose presence in the list is to be tested.
	 * @return true if the list contains the given element.
	 * @throws NullPointerException If the element is null and this list does not permit null elements.
	 */
	public boolean contains(Element element) throws NullPointerException {
		if (element == null) {
			throw new NullPointerException("The list does not permit null elements");
		}
		if (!isEmpty()) {
			// Navigate through the list
			Node<Element> current = head;
			while (current.next != null) {
				if (current.element == element) {
					// Element found, return true
					return true;
				}
				current = current.next;
			}
		}
		return false;
	}
	
	/**
	 * Removes the element at the specified position in the list.
	 * Shifts any subsequent elements to the left.
	 * @param index The index of the element to be removed.
	 * @returns The element that was removed from the list or null otherwise.
	 * @throws IndexOutOfBoundsException if the index is out of bounds (index < 0 || index >= size()).
	 */
	public Element remove(int index) throws IndexOutOfBoundsException {
		if (isEmpty()) {
			return null;
		}
		// First, check if the index is valid
		if (index >= 0 && index < size) {
			if (index == 0) {
				// Remove the first element from the list
				Element element = head.element;
				head = head.next;
				return element;
			} else {
				// Navigate to the required element.
				Node<Element> previous = null;
				Node<Element> current = head;
				for (int i = 0; i < index; i++) {
					previous = current;
					current = current.next;
				}
				Element element = current.element;
				previous.next = current.next;
				size--;
				return element;
			}
		} else {
			throw new IndexOutOfBoundsException("Index " + index + " out of range");
		}
	}
	
	/**
	 * Removes the first occurrence of the specified element from this list, if it is present.
	 * If the list does not contain the element, it remains unchanged.
	 * @param element The element to be removed from the list, if present.
	 * @returns Returns true if this list contained the specified element and false otherwise.
	 * @throws NullPointerException If the element is null and this list does not permit null elements.
	 */
	public boolean remove(Element element) {
		if (element == null) {
			throw new NullPointerException("The list does not permit null elements");
		}
		Node<Element> previous = null;
		Node<Element> current = head;
		while (current != null) {
			if (current.element.equals(element)) {
				if (current == head) {
					// Remove the head (special case)
					head = head.next;
				} else {
					previous.next = current.next;
				}
				return true;
			}
			previous = current;
			current = current.next;
		}
		size--;
		return false;
	}
	
	/**
	 * Returns true if this list contains no elements.
	 * @return true is the list is empty, false otherwise.
	 */
	public boolean isEmpty() {
		return head == null;
	}
	
	/**
	 * Returns the size of this list.
	 * @return The number of elements in this list.
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Removes all the elements from this list.
	 * The list will be empty after this call returns.
	 */
	public void clear() {
		head = null;
		size = 0;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		StringBuilder list = new StringBuilder("[");
		Node<Element> current = head;
		while (current != null) {
			list.append(current.element);
			list.append(current.next == null ? "" : ", ");
			current = current.next;
		}
		list.append("]");
		return list.toString();
	}
	
	/**
	 * Node class, used to link the elements together.
	 */
	private class Node<Element> {
		public Node<Element> next;
		public Element element;
		
		public Node(Element element) {
			this.element = element;
		}
		
	}
	
}
