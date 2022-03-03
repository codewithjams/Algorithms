package ritwik.codes.algorithms.sort;

/**
 * Utilities to package all utilitarian methods helpful in sorting.
 *
 * @author ritwikjamuar
 */
public class SortUtilities {

	/**
	 * Swaps two items in the given {@code array}.
	 *
	 * @param array Array of {@link Integer} denoting the collection at which swap is to be performed.
	 * @param from {@link Integer} denoting the index of the first item.
	 * @param to {@link Integer} denoting the index of second item.
	 */
	public static void swapItems(int[] array, int from, int to) {
		int temp = array[from];
		array[from] = array[to];
		array[to] = temp;
	}

}
