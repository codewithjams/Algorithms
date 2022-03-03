package ritwik.codes.algorithms.sort;

public class BubbleSortTest extends BaseSortTest {

	/*-------------------------------------------- BaseSortTest Callbacks --------------------------------------------*/

	@Override
	protected Sort provideSort(int[] array, int size) {
		return new BubbleSort(array, size);
	}

}
