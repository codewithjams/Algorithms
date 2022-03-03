package ritwik.codes.algorithms.search;

public class BinarySearchTest extends BaseSearchTest {

	/*------------------------------------------- BaseSearchTest Callbacks -------------------------------------------*/

	@Override
	protected Search provideSearch(int[] array, int size) {
		return new BinarySearch(array, size);
	}

}
