package ritwik.codes.dataStructures.list.linkedList;

class Node<T> {

	/*-------------------------------------------------- Components --------------------------------------------------*/

	private T data;
	private Node<T> link;

	/*------------------------------------------------- Constructors -------------------------------------------------*/

	public Node() {
		this.link = null;
	}

	public Node(T data, Node<T> link) {
		this.data = data;
		this.link = link;
	}

	/*-------------------------------------------------- Accessors ---------------------------------------------------*/

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getLink() {
		return link;
	}

	public void setLink(Node<T> link) {
		this.link = link;
	}

}
