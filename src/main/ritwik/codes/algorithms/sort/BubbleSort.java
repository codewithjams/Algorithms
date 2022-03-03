package ritwik.codes.algorithms.sort;

public class BubbleSort implements Sort {

	/*-------------------------------------------------- Components --------------------------------------------------*/

	private final int[] array;

	private final int size;

	/*------------------------------------------------- Constructors -------------------------------------------------*/

	public BubbleSort(int[] array, int size) {
		this.array = new int[size];
		this.size = size;
		System.arraycopy(array, 0, this.array, 0, size);
	}

	/*------------------------------------------------ Sort Callbacks ------------------------------------------------*/

	@Override
	public int[] sort() {
		int to = 0;
		while (runPass(to)) {
			++to;
		}
		return array;
	}

	/*----------------------------------------------- Private Methods ------------------------------------------------*/

	private boolean runPass(int to) {
		boolean isSorted = true;
		for (int i = 0; i < size - to - 1; ++i) {
			if (array[i] > array[i + 1]) {
				SortUtilities.swapItems(array, i, i + 1);
				isSorted = false;
			}
		}
		return !isSorted;
	}

}
