package ritwik.codes.dataStructures.queues;

class QueueNode {
	private QueueNode next;
	private QueueNode previous;
	private int data;

	QueueNode () {}

	QueueNode getNext () { return next; }
	void setNext ( QueueNode next ) { this.next = next; }

	QueueNode getPrevious () { return previous; }
	void setPrevious ( QueueNode previous ) { this.previous = previous; }

	int getData () { return data; }
	void setData ( int data ) { this.data = data; }
}

public class LinkedListQueue {
	private QueueNode front;
	private QueueNode rear;

	public LinkedListQueue () {}

	@Override public String toString () {
		StringBuilder builder = new StringBuilder ( "[" );
		if ( ! isEmpty () ) {
			QueueNode pointer = new QueueNode ();
			pointer.setNext ( front.getNext () );
			pointer.setPrevious ( front.getPrevious () );
			pointer.setData ( front.getData () );

			while ( pointer != null ) {
				builder.append ( pointer.getData () ).append ( pointer.getNext () == null ? "" : ", " );
				pointer = pointer.getNext ();
			}
		}
		builder.append ( "]" );
		return builder.toString ();
	}

	public boolean isEmpty () {
		return front == null && rear == null;
	}

	public void enqueue ( int data ) {
		QueueNode temp = new QueueNode ();
		temp.setData ( data );

		if ( isEmpty () ) {
			front = temp;
			rear = temp;
		} else {
			rear.setNext ( temp );
			temp.setPrevious ( rear );
			rear = temp;
		}
	}

	public void dequeue () {
		if ( isEmpty () ) return;
		if ( front == rear ) {
			front = null;
			rear = null;
		} else {
			front = front.getNext ();
			front.setPrevious ( null );
		}
	}
}