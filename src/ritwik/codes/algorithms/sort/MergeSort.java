package ritwik.codes.algorithms.sort;

public class MergeSort implements Sort {
	private int [] array;
	private int size;

	public MergeSort ( int [] array, int size ) {
		this.array = new int [ size ];
		this.size = size;
		System.arraycopy ( array, 0, this.array, 0, size );
	}

	@Override public int[] sort () {
		return mergeSort ( array, size );
	}

	private int [] merge ( int [] left, int [] right ) {
		int i = 0;
		int j = 0;
		int k = 0;
		int nL = left.length;
		int nR = right.length;
		int a [] = new int [ nL + nR ];

		while ( i < nL && j < nR ) {
			if ( left [ i ] < right [ j ] ) {
				a [ k ] = left [ i ];
				++i;
			} else {
				a [ k ] = right [ j ];
				++j;
			}
			++k;
		}

		while ( i < nL ) {
			a [ k ] = left [ i ];
			++i;
			++k;
		}

		while ( j < nR ) {
			a [ k ] = right [ j ];
			++j;
			++k;
		}

		return a;
	}

	private int [] mergeSort ( int a [], int n ) {
		if ( n == 1 ) return a;
		int mid = n / 2;

		int left [] = new int [ mid ];
		int right [] = new int [ n - mid ];

		System.arraycopy ( a, 0, left, 0, mid );
		System.arraycopy ( a, mid, right, 0, n - mid );

		left = mergeSort ( left, mid );
		right = mergeSort ( right, n - mid );
		a = merge ( left, right );
		return a;
	}
}