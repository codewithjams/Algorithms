package ritwik.codes.algorithms;

import ritwik.codes.algorithms.search.BinarySearch;
import ritwik.codes.algorithms.sort.*;

import java.util.Scanner;

public class Main {
	private Scanner mScanner;

	private Main () {}

	public static void main ( String [] args ) {
		Main main = new Main ();
		main.initialize ();

		switch ( main.inputChoice () ) {
			case 1 : {
				int size = main.inputArraySize ();
				int [] array = main.inputArrayElements ( size );

				main.doSelectionSort ( array, size );
				main.doBubbleSort ( array, size );
				main.doInsertionSort ( array, size );
				main.doMergeSort ( array, size );
				main.doQuickSort ( array, size );
			} break;

			case 2 : {
				int size = main.inputArraySize ();
				int [] array = main.inputArrayElements ( size );
				int elementToFind = main.inputElementToFind ();

				main.doBinarySearch ( array, size, elementToFind );
			} break;

			default : {
				main.printLineConsoleOutput ( "Wrong Choice Entered" );
			}
		}
	}

	private void initialize () {
		mScanner = new Scanner ( System.in );
	}

	private int inputChoice () {
		printConsoleOutput ( "1. Sort\n2. Search\nEnter your choice : " );
		return mScanner.nextInt ();
	}

	private int inputElementToFind () {
		printConsoleOutput ( "Enter element to find in the Array : " );
		return mScanner.nextInt ();
	}

	private int inputArraySize () {
		printConsoleOutput ( "Enter size of Array : " );
		return mScanner.nextInt ();
	}

	private int [] inputArrayElements ( int size ) {
		int [] a = new int [ size ];
		printLineConsoleOutput ( "Enter the elements of Array :" );
		for ( int i = 0; i < size; ++i ) {
			a [ i ] = mScanner.nextInt ();
		}
		return a;
	}

	private void doSelectionSort ( int [] a, int n ) {
		int [] sortedArray = a;
		SelectionSort selectionSort = new SelectionSort ( sortedArray, n );
		sortedArray = selectionSort.sort ();
		printLineConsoleOutput ( "Sorted array with Selection Sort is" );
		for ( int i = 0; i < n; ++i ) {
			printConsoleOutput ( sortedArray [ i ] + " " );
		}
	}

	private void doBubbleSort ( int [] a, int n ) {
		int [] sortedArray = a;
		BubbleSort bubbleSort = new BubbleSort ( sortedArray, n );
		sortedArray = bubbleSort.sort ();
		printLineConsoleOutput ( "\nSorted array with Bubble Sort is" );
		for ( int i = 0; i < n; ++i ) {
			printConsoleOutput ( sortedArray [ i ] + " " );
		}
	}

	private void doInsertionSort ( int [] a, int n ) {
		int [] sortedArray = a;
		InsertionSort insertionSort = new InsertionSort ( sortedArray, n );
		sortedArray = insertionSort.sort ();
		printLineConsoleOutput ( "\nSorted array with Insertion Sort is" );
		for ( int i = 0; i < n; ++i ) {
			printConsoleOutput ( sortedArray [ i ] + " " );
		}
	}

	private void doMergeSort ( int [] a, int n ) {
		int [] sortedArray = a;
		MergeSort mergeSort = new MergeSort ( sortedArray, n );
		sortedArray = mergeSort.sort ();
		printLineConsoleOutput ( "\nSorted array with Merge Sort is" );
		for ( int i = 0; i < n; ++i ) {
			printConsoleOutput ( sortedArray [ i ] + " " );
		}
	}

	private void doQuickSort ( int [] a, int n ) {
		int [] sortedArray = a;
		QuickSort quickSort = new QuickSort ( sortedArray, n );
		sortedArray = quickSort.sort ();
		printLineConsoleOutput ( "\nSorted array with Quick Sort is" );
		for ( int i = 0; i < n; ++i ) {
			printConsoleOutput ( sortedArray [ i ] + " " );
		}
	}

	private void doBinarySearch ( int [] a, int n, int x ) {
		BinarySearch search = new BinarySearch ( a, n );
		int resultIndex = search.search ( x );
		printLineConsoleOutput ( resultIndex == -1 ? "Item not found" : "Item found at Position " + ( resultIndex + 1 ) );
	}

	private void printLineConsoleOutput ( String message ) {
		System.out.println ( message );
	}

	private void printConsoleOutput ( String message ) {
		System.out.print ( message );
	}
}