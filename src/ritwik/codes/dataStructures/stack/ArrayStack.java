package ritwik.codes.dataStructures.stack;

public class ArrayStack {
	private int [] array;
	private int top;

	public static final int INVALID_VALUE = -1;
	private static final int MAX_SIZE = 10;

	public ArrayStack () {
		this.array = new int [ MAX_SIZE ];
		this.top = INVALID_VALUE;
	}

	@Override public String toString () {
		StringBuilder builder = new StringBuilder ( "[ " );
		for ( int i = 0; i <= top; ++i ) {
			builder.append ( array [ i ] ).append ( i == top ? " " : ", " );
		}
		builder.append ( "]" );
		return builder.toString ();
	}

	public void push ( int x ) {
		if ( top == MAX_SIZE - 1 ) return;
		top += 1;
		array [ top ] = x;
	}

	public void pop () {
		if ( top >= 0 ) {
			top -= 1;
		}
	}

	public int top () {
		return top < 0 ? INVALID_VALUE : array [ top ];
	}

	public boolean isEmpty () {
		return top == -1;
	}
}