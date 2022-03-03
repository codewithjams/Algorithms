package ritwik.codes.algorithms.sort;

public class QuickSort implements Sort {

	private final int[] array;
	private final int size;

	public QuickSort(int[] array, int size) {
		this.array = new int[size];
		this.size = size;
		System.arraycopy(array, 0, this.array, 0, size);
	}

	@Override
	public int[] sort() {
		quickSort(array, 0, size - 1);
		return array;
	}

	private void swapItems(int[] a, int from, int to) {
		int temp = a[from];
		a[from] = a[to];
		a[to] = temp;
	}

	private int partition(int[] a, int start, int end) {
		int pivot = a[end];
		int pIndex = start;
		for (int i = start; i < end; ++i) {
			if (a[i] <= pivot) {
				swapItems(a, i, pIndex);
				pIndex = pIndex + 1;
			}
		}
		swapItems(a, pIndex, end);
		return pIndex;
	}

	private void quickSort(int[] a, int start, int end) {
		int pIndex;
		if (start < end) {
			pIndex = partition(a, start, end);
			quickSort(a, start, pIndex - 1);
			quickSort(a, pIndex + 1, end);
		}
	}

}
