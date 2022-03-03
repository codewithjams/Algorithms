package ritwik.codes.algorithms.sort;

import com.google.common.truth.Truth;

import org.junit.Test;

public abstract class BaseSortTest {

	/*-------------------------------------------------- Test Cases --------------------------------------------------*/

	@Test
	public void testCase1() {
		int[] input = new int[] {7, 19, 59, 37, 23};
		int[] expectedOutput = new int[] {7, 19, 23, 37, 59};
		testSort(input, expectedOutput);
	}

	@Test
	public void testCase2() {
		int[] input = new int[] {5, 4, 3, 2, 1};
		int[] expectedOutput = new int[] {1, 2, 3, 4, 5};
		testSort(input, expectedOutput);
	}

	@Test
	public void testCase3() {
		int[] input = new int[] {1, 2, 3};
		int[] expectedOutput = new int[] {1, 2, 3};
		testSort(input, expectedOutput);
	}

	@Test
	public void testCase4() {
		int[] input = new int[] {2, 1};
		int[] expectedOutput = new int[] {1, 2};
		testSort(input, expectedOutput);
	}

	/*------------------------------------------------ Private Methods -----------------------------------------------*/

	private void testSort(int[] input, int[] expectedOutput) {
		Sort sort = provideSort(input, input.length);
		int[] output = sort.sort();
		Truth.assertThat(output).isEqualTo(expectedOutput);
	}

	/*----------------------------------------------- Abstract Methods -----------------------------------------------*/

	protected abstract Sort provideSort(int[] array, int size);

}
