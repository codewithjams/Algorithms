package ritwik.codes.algorithms.sort;

public class SelectionSort implements Sort {

	private final int[] array;
	private final int size;

	public SelectionSort(int[] array, int size) {
		this.array = new int[size];
		this.size = size;
		System.arraycopy(array, 0, this.array, 0, size);
	}

	@Override
	public int[] sort() {
		for (int i = 0; i < size - 1; ++i) {
			SortUtilities.swapItems(array, i, findMinimumElementIndex(i));
		}
		return array;
	}

	private int findMinimumElementIndex(int from) {
		int min = from;
		for (int i = from + 1; i < size; ++i) {
			if (array[i] < array[min]) {
				min = i;
			}
		}
		return min;
	}

}
