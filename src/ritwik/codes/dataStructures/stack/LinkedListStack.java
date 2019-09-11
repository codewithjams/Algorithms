package ritwik.codes.dataStructures.stack;

class Node {
	private int data;
	private Node link;

	Node () {
		this.data = 0;
		this.link = null;
	}

	int getData () { return data; }
	void setData ( int data ) { this.data = data; }

	Node getLink () { return link; }
	void setLink ( Node link ) { this.link = link; }
}

public class LinkedListStack {
	private Node head;

	public LinkedListStack () {
		this.head = null;
	}

	@Override public String toString () {
		StringBuilder builder = new StringBuilder ( "[ " );
		Node position = head;
		while ( position != null ) {
			builder.append ( position.getData () ).append ( position.getLink () == null ? " " : ", " );
			position = position.getLink ();
		}
		builder.append ( "]" );
		return builder.toString ();
	}

	public void push ( int data ) {
		Node temp = new Node ();
		temp.setData ( data );

		if ( head == null ) {
			head = temp;
		} else {
			temp.setLink ( head );
			head = temp;
		}
	}

	public void pop () {
		if ( head == null ) return;
		//Node temp = head;
		head = head.getLink ();
	}

	public int top () { return isEmpty () ? -1 : head.getData (); }

	public boolean isEmpty () { return head == null; }
}