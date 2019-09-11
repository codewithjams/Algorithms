package ritwik.codes.problems;

public class PascalTriangle {

	private PascalTriangle () {}

	public static void main ( String [] args ) {
		PascalTriangle triangle = new PascalTriangle ();
		triangle.print2DArray ( triangle.solve ( 5 ) );
	}

	private int [] [] solve ( int a ) {
		int array [] [] = new int [ a ] [];
		for ( int i = 0; i < a; ++i ) {
			array [ i ] = new int [ i + 1 ];
			array [ i ] [ 0 ] = 1;
			array [ i ] [ i ] = 1;
			for ( int j = 1 ; j < i; ++j ) {
				array [ i ] [ j ] = array [ i - 1 ] [ j - 1 ] + array [ i - 1 ] [ j ];
			}
		}
		return array;
	}

	private void printConsoleOutput ( String message ) {
		System.out.print ( message );
	}

	private void print2DArray ( int [] [] array ) {
		for ( int i = 0; i < array.length; ++i ) {
			for ( int j = 0; j < array [ i ].length; ++j ) {
				printConsoleOutput ( array [ i ] [ j ] + " " );
			}
			System.out.println ();
		}
	}
}