/* Code Source : https://www.sanfoundry.com/java-program-implement-singly-linked-list/ */

package ritwik.codes.dataStructures.linkedList;

public class LinkedList<T> {

	/*-------------------------------------------------- Components --------------------------------------------------*/

	private Node<T> start;
	private Node<T> end;

	private int size;

	/*-------------------------------------------------- Constructor -------------------------------------------------*/

	public LinkedList() {
		this.start = null;
		this.end = null;
		this.size = 0;
	}

	/*----------------------------------------------- Object Callbacks -----------------------------------------------*/

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("[");
		if (this.size == 0) {
			builder.append("]");
		} else {
			if (this.start.getLink() == null) {
				builder.append(this.start.getData()).append(", ");
			} else {
				Node<T> pointer = this.start;
				builder.append(pointer.getData()).append(", ");
				pointer = this.start.getLink();
				while (pointer.getLink() != null) {
					builder.append(pointer.getData()).append(", ");
					pointer = pointer.getLink();
				}
				builder.append(pointer.getData()).append("]");
			}
		}
		return builder.toString();
	}

	/*------------------------------------------------ Private Methods -----------------------------------------------*/

	private void insertAtStart(T data) {
		Node<T> nPtr = new Node<>(data, null);
		this.size++;
		if (isEmpty()) {
			this.start = nPtr;
			this.end = this.start;
		} else {
			nPtr.setLink(start);
			nPtr.setData(data);
		}
	}

	private void insertAtEnd(T data) {
		Node<T> nPtr = new Node<>(data, null);
		this.size++;
		if (isEmpty()) {
			this.start = nPtr;
			this.end = this.start;
		} else {
			end.setLink(nPtr);
			end.setData(data);
		}
	}

	private void insertAtPosition(T data, int position) {
		Node<T> nPtr = new Node<>(data, null);
		Node<T> pointer = this.start;
		position -= 1;
		for (int i = 0; i < this.size; ++i) {
			if (position == i) {
				Node<T> temp = pointer.getLink();
				pointer.setLink(nPtr);
				nPtr.setLink(temp);
				break;
			}
			pointer = pointer.getLink();
		}
		this.size++;
	}

	private void deleteAtStart() {
		this.start = start.getLink();
		this.size--;
	}

	private void deleteAtEnd() {
		Node<T> s = this.start;
		Node<T> t = this.start;
		while (s != end) {
			t = s;
			s = s.getLink();
		}
		this.end = t;
		this.end.setLink(null);
		this.size--;
	}

	private void deleteAtPosition(int position) {
		Node<T> pointer = this.start;
		for (int i = 0; i < this.size; ++i) {
			if (position == i) {
				Node<T> temp = pointer.getLink();
				temp = temp.getLink();
				pointer.setLink(temp);
				break;
			}
			pointer = pointer.getLink();
		}
		this.size--;
	}

	@SuppressWarnings("unused")
	private void reverseUsingLoop() {

		Node<T> current = this.start;
		Node<T> previous = null;
		Node<T> next;

		while (current != null) {
			next = current.getLink();
			current.setLink(previous);
			previous = current;
			current = next;
		}
		this.start = previous;
	}

	@SuppressWarnings("unused")
	private void reverseUsingRecursion(Node<T> p) {
		if (p.getLink() == null) {
			start = p;
			return;
		}

		reverseUsingRecursion(p.getLink());

		Node<T> q = p.getLink();
		q.setLink(p);
		p.setLink(null);
	}

	/*------------------------------------------------ Public Methods ------------------------------------------------*/

	/**
	 * Checks whether List is empty or not.
	 *
	 * @return {@code true} if the List is empty, else {@code false}
	 */
	public boolean isEmpty() {
		return this.start == null;
	}

	/**
	 * Gives size of the List.
	 *
	 * @return 0 if List is empty, else, size of List.
	 */
	public int getSize() {
		return this.size;
	}

	/**
	 * Inserts the {@code data} in Last Index of List.
	 *
	 * @param data Integer to be added in the list.
	 */
	public void insert(T data) {
		if (this.size == 0) {
			insertAtStart(data);
		} else {
			insertAtPosition(data, this.size);
		}
	}

	/**
	 * Inserts the data in the List.
	 *
	 * @param data     Value of Data to be stored in the List.
	 * @param position Positive Integer starting from 1 or size of List.
	 */
	public void insert(T data, int position) {
		if (position < 0 || position > size) return;
		if (position == 0) {
			insertAtStart(data);
		} else if (position == size - 1) {
			insertAtEnd(data);
		} else {
			insertAtPosition(data, position);
		}
	}

	/**
	 * Deletes the last node in the List until the List is empty.
	 */
	public void delete() {
		if (this.size == 0) return;
		deleteAtEnd();
	}

	/**
	 * Deletes the Item at provided position.
	 *
	 * @param position Positive Integer starting from 1 or size of List
	 */
	public void delete(int position) {
		position -= 1;
		if (position < -1 || position > size) return;
		if (position == 0) {
			deleteAtStart();
		} else if (position == this.size - 1) {
			deleteAtEnd();
		} else {
			deleteAtPosition(position - 1);
		}
	}

	public T get(int position) {
		// Buggy
		Node<T> pointer = start;
		if (position == 1) {
			return pointer.getData();
		}
		do {
			pointer = pointer.getLink();
			position -= 1;
		} while (position > 0);

		if (pointer == null) return null;
		else return pointer.getData();
	}

	public void reverse() {
		// reverseUsingLoop (); // Iterative Approach
		reverseUsingRecursion(start); // Recursive Approach
	}

}
