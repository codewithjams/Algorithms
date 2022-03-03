package ritwik.codes.dataStructures.stack;

class CharArrayStack {

	private final char [] a;

	private int top;

	CharArrayStack ( int length ) {
		this.a = new char [ length ];
		this.top = -1;
	}

	void push ( char c ) {
		if ( top >= a.length ) return;
		top += 1;
		a [ top ] = c;
	}

	void pop () {
		if ( top == -1 ) return;
		top -= 1;
	}

	char top () { return isEmpty () ? '\n' : a [ top ]; }

	private boolean isEmpty () { return top == -1; }

}

public class ReverseString {

	public String reverse ( String text ) {
		char[] textArray = text.toCharArray ();
		int length = textArray.length;

		CharArrayStack stack = new CharArrayStack ( length );

		for ( char aTextArray : textArray ) {
			stack.push ( aTextArray );
		}

		for ( int i = 0; i < length; ++i ) {
			textArray[ i ] = stack.top ();
			stack.pop ();
		}

		return new String ( textArray );
	}

}
