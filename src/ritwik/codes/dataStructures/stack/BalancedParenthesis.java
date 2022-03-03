package ritwik.codes.dataStructures.stack;

class Stack {

	private static final int MAX_SIZE = 100;

	private final char[] array;

	private int top;

	Stack() {
		this.array = new char[MAX_SIZE];
		this.top = -1;
	}

	void push(char c) {
		array[top] = c;
		top += 1;
	}

	void pop() {
		array[top] = '\0';
		top -= 1;
	}

	boolean isEmpty() {
		return top == -1;
	}
}

public class BalancedParenthesis {
}
