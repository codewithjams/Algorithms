package ritwik.codes.algorithms.sort;

public class InsertionSort implements Sort {

	private final int[] array;
	private final int size;

	public InsertionSort(int[] array, int size) {
		this.array = new int[size];
		this.size = size;
		System.arraycopy(array, 0, this.array, 0, size);
	}

	@Override
	public int[] sort() {
		for (int i = 0; i < size; ++i) {
			fillTheHole(i);
		}
		return array;
	}

	private void fillTheHole(int from) {
		int value = array[from];
		int hole = from;

		while (hole > 0 && array[hole - 1] > value) {
			swapItems(hole, hole - 1);
			hole -= 1;
		}
	}

	private void swapItems(int from, int to) {
		int temp = array[from];
		array[from] = array[to];
		array[to] = temp;
	}

}
