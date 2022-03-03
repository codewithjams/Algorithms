package ritwik.codes.dataStructures.linkedList;

class Node {

	private int data;
	private Node link;

	Node() {
		this.data = 0;
		this.link = null;
	}

	Node(int data, Node link) {
		this.data = data;
		this.link = link;
	}

	int getData() {
		return data;
	}

	void setData(int data) {
		this.data = data;
	}

	Node getLink() {
		return link;
	}

	void setLink(Node link) {
		this.link = link;
	}

}
