package ritwik.codes.algorithms.sort;

public class SelectionSortTest extends BaseSortTest {

	/*-------------------------------------------- BaseSortTest Callbacks --------------------------------------------*/

	@Override
	protected Sort provideSort(int[] array, int size) {
		return new SelectionSort(array, size);
	}

}
