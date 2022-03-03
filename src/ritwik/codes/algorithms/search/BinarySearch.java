package ritwik.codes.algorithms.search;

public class BinarySearch implements Search {

	private final int[] array;
	private final int size;

	public BinarySearch(int[] array, int size) {
		this.array = new int[size];
		this.size = size;
		System.arraycopy(array, 0, this.array, 0, size);
	}

	@Override
	public int search(int x) {
		int start = 0;
		int end = size - 1;
		int mid;
		while (start <= end) {
			mid = (start + end) / 2;
			if (x == array[mid]) {
				return mid;
			} else if (x > array[mid]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return -1;
	}

}
