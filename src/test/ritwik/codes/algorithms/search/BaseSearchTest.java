package ritwik.codes.algorithms.search;

import com.google.common.truth.Truth;

import org.junit.Test;

public abstract class BaseSearchTest {

	@Test
	public void testCase1() {
		int[] array = new int[] {1, 4, 9, 16, 25, 36, 49, 64};
		int searchCandidate = 4;
		int expectedPosition = 1;
		testSearch(array, searchCandidate, expectedPosition);
	}

	@Test
	public void testCase2() {
		int[] array = new int[] {1, 2, 3, 4, 5, 6, 7, 8};
		int searchCandidate = -1;
		int expectedPosition = -1;
		testSearch(array, searchCandidate, expectedPosition);
	}

	@Test
	public void testCase3() {
		int[] array = new int[] {-17, -13, -11, -7, -5, -3, -2, 2, 3};
		int searchCandidate = -7;
		int expectedPosition = 3;
		testSearch(array, searchCandidate, expectedPosition);
	}

	@Test
	public void testCase4() {
		int[] array = new int[] {6, 17, 23, 11, 2, 7, 3};
		int searchCandidate = 17;
		int expectedPosition = -1;
		testSearch(array, searchCandidate, expectedPosition);
	}

	private void testSearch(int[] array, int searchCandidate, int expectedPosition) {
		Search search = provideSearch(array, array.length);
		int position = search.search(searchCandidate);
		Truth.assertThat(position).isEqualTo(expectedPosition);
	}

	protected abstract Search provideSearch(int[] array, int size);

}
