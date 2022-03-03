package ritwik.codes.algorithms;

import ritwik.codes.algorithms.search.BinarySearch;

import ritwik.codes.algorithms.search.Search;

import ritwik.codes.algorithms.sort.*;

import java.util.Scanner;

public class Main {

	/*-------------------------------------------------- Components --------------------------------------------------*/

	private Scanner mScanner;

	/*------------------------------------------------- Constructors -------------------------------------------------*/

	private Main() {
	}

	/*------------------------------------------------ Static Methods ------------------------------------------------*/

	public static void main(String[] args) {

		Main main = new Main();
		main.initialize();

		switch (main.inputChoice()) {

			case 1:
				handleSortSelection(main);
				break;

			case 2:
				handleSearchSelection(main);
				break;

			default: {
				main.printLineConsoleOutput("Wrong Choice Entered");
			}

		}

	}

	private static void handleSortSelection(Main main) {
		int size = main.inputArraySize();
		int[] array = main.inputArrayElements(size);

		main.doSelectionSort(array, size);
		main.doBubbleSort(array, size);
		main.doInsertionSort(array, size);
		main.doMergeSort(array, size);
		main.doQuickSort(array, size);
	}

	private static void handleSearchSelection(Main main) {
		int size = main.inputArraySize();
		int[] array = main.inputArrayElements(size);
		int elementToFind = main.inputElementToFind();

		main.doBinarySearch(array, size, elementToFind);
	}

	/*----------------------------------------------- Private Methods ------------------------------------------------*/

	private void initialize() {
		mScanner = new Scanner(System.in);
	}

	private int inputChoice() {
		printConsoleOutput("1. Sort\n2. Search\nEnter your choice : ");
		return mScanner.nextInt();
	}

	private int inputElementToFind() {
		printConsoleOutput("Enter element to find in the Array : ");
		return mScanner.nextInt();
	}

	private int inputArraySize() {
		printConsoleOutput("Enter size of Array : ");
		return mScanner.nextInt();
	}

	private int[] inputArrayElements(int size) {
		int[] a = new int[size];
		printLineConsoleOutput("Enter the elements of Array :");
		for (int i = 0; i < size; ++i) {
			a[i] = mScanner.nextInt();
		}
		return a;
	}

	private void doSelectionSort(int[] a, int n) {
		performSortAndShow(new SelectionSort(a, n));
	}

	private void doBubbleSort(int[] a, int n) {
		performSortAndShow(new BubbleSort(a, n));
	}

	private void doInsertionSort(int[] a, int n) {
		performSortAndShow(new InsertionSort(a, n));
	}

	private void doMergeSort(int[] a, int n) {
		performSortAndShow(new MergeSort(a, n));
	}

	private void doQuickSort(int[] a, int n) {
		performSortAndShow(new QuickSort(a, n));
	}

	private void performSortAndShow(Sort sort) {
		int[] sortedArray = sort.sort();
		printLineConsoleOutput("\nSorted array is:");
		for (int j : sortedArray) {
			printConsoleOutput(j + " ");
		}
	}

	private void doBinarySearch(int[] a, int n, int x) {
		performSearch(new BinarySearch(a, n), x);
	}

	private void performSearch(Search search, int searchCandidate) {
		int resultIndex = search.search(searchCandidate);
		printLineConsoleOutput(resultIndex == -1 ? "Item not found" : "Item found at Position " + (resultIndex + 1));
	}

	private void printLineConsoleOutput(String message) {
		System.out.println(message);
	}

	private void printConsoleOutput(String message) {
		System.out.print(message);
	}

}
