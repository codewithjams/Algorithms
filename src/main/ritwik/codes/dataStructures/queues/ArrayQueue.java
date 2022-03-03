package ritwik.codes.dataStructures.queues;

public class ArrayQueue {

	private static final int MAX_SIZE = 10;

	private final int[] array;

	private int front, rear;

	private final boolean isCircular;

	public ArrayQueue(boolean isCircular) {
		this.array = new int[MAX_SIZE];
		this.front = -1;
		this.rear = -1;
		this.isCircular = isCircular;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("[");
		if (front != -1 && rear != -1) {
			for (int i = front; i <= rear; ++i) {
				builder.append(array[i]).append(i == rear ? "" : ", ");
			}
		}
		builder.append("]");
		return builder.toString();
	}

	public boolean isEmpty() {
		return front == -1 && rear == -1;
	}

	private boolean isFull() {
		if (isCircular) {
			return rear == MAX_SIZE;
		} else {
			return (rear + 1 % MAX_SIZE) == front;
		}
	}

	public void enqueue(int x) {
		if (isFull()) {
			return;
		} else if (isEmpty()) {
			front += 1;
			rear += 1;
		} else {
			rear = isCircular ? rear + 1 : (rear + 1) % MAX_SIZE;
		}
		array[rear] = x;
	}

	public void dequeue() {
		if (!isEmpty()) {
			front += 1;
		}
	}

	public int front() {
		if (isEmpty()) return -1;
		else return array[front];
	}

}
