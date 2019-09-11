package ritwik.codes.algorithms.sort;

public class SelectionSort implements Sort {
	private int [] array;
	private int size;

	public SelectionSort ( int [] array, int size ) {
		this.array = new int [ size ];
		this.size = size;
		System.arraycopy ( array, 0, this.array, 0, size );
	}

	@Override public int [] sort () {
		for ( int i = 0; i < size - 1; ++i ) {
			swapElements ( i, findMinimumElementIndex ( i ) );
		}
		return array;
	}

	private int findMinimumElementIndex ( int from ) {
		int min = from;
		for ( int i = from + 1; i < size; ++i ) {
			if ( array [ i ] < array [ min ] ) {
				min = i;
			}
		}
		return min;
	}

	private void swapElements ( int a, int b ) {
		int temp = array [ a ];
		array [ a ] = array [ b ];
		array [ b ] = temp;
	}
}