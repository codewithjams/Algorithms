package ritwik.codes.algorithms.sort;

public class QuickSortTest extends BaseSortTest {

	/*-------------------------------------------- BaseSortTest Callbacks --------------------------------------------*/

	@Override
	protected Sort provideSort(int[] array, int size) {
		return new QuickSort(array, size);
	}

}
