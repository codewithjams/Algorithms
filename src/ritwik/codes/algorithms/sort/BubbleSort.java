package ritwik.codes.algorithms.sort;

public class BubbleSort implements Sort {
	private int [] array;
	private int size;

	public BubbleSort ( int [] array, int size ) {
		this.array = new int [ size ];
		this.size = size;
		System.arraycopy ( array, 0, this.array, 0, size );
	}

	@Override public int [] sort () {
		int to = 0;
		while ( runPass ( to ) ) {
			++to;
		}
		return array;
	}

	private boolean runPass ( int to ) {
		boolean isSorted = true;
		for ( int i = 0; i < size - to - 1; ++i ) {
			if ( array [ i ] > array [ i + 1 ] ) {
				swapElements ( i, i + 1 );
				isSorted = false;
			}
		}
		return ! isSorted;
	}

	private void swapElements ( int from, int to ) {
		int temp = array [ from ];
		array [ from ] = array [ to ];
		array [ to ] = temp;
	}
}