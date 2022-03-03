package ritwik.codes.algorithms.sort;

public class MergeSortTest extends BaseSortTest {

	/*-------------------------------------------- BaseSortTest Callbacks --------------------------------------------*/

	@Override
	protected Sort provideSort(int[] array, int size) {
		return new MergeSort(array, size);
	}

}
