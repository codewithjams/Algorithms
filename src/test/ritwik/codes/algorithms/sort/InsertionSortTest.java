package ritwik.codes.algorithms.sort;

public class InsertionSortTest extends BaseSortTest {

	/*-------------------------------------------- BaseSortTest Callbacks --------------------------------------------*/

	@Override
	protected Sort provideSort(int[] array, int size) {
		return new InsertionSort(array, size);
	}

}
