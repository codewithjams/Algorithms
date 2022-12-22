package ritwik.codes.dataStructures.array;

import com.google.common.truth.BooleanSubject;
import com.google.common.truth.Truth;

import org.junit.Test;

/**
 * Unit Test cases for different methods of {@link ArrayUtils}.
 *
 * @author ritwikjamuar
 */
public class ArrayUtilsTest {

	/*------------------------------------------------ Public Methods ------------------------------------------------*/

	@Test
	public void testCase001() {
		testArrayInsert(
				new int[]{3, 8, 12, 5, 6, Integer.MIN_VALUE, Integer.MIN_VALUE},
				5,
				7,
				4,
				2,
				new int[]{3, 4, 8, 12, 5, 6, Integer.MIN_VALUE}
		);
	}

	@Test
	public void testCase002() {
		testArrayInsert(
				new int[]{3, 8, 12, 5, 6, Integer.MIN_VALUE, Integer.MIN_VALUE},
				5,
				7,
				11,
				6,
				new int[]{3, 8, 12, 5, 6, 11, Integer.MIN_VALUE}
		);
	}

	@Test
	public void testCase003() {
		testArrayInsert(
				new int[]{3, 8, 12, 5, 6, Integer.MIN_VALUE, Integer.MIN_VALUE},
				5,
				7,
				2,
				1,
				new int[]{2, 3, 8, 12, 5, 6, Integer.MIN_VALUE}
		);
	}

	@Test
	public void testCase004() {
		testArrayInsert(
				new int[]{3, 8, 12, 5, 6},
				5,
				5,
				2,
				1,
				new int[]{3, 8, 12, 5, 6}
		);
	}

	@Test
	public void testCase005() {
		testArrayDelete(new int[]{3, 8, 12, 5, 6}, 8, new int[]{3, 12, 5, 6, Integer.MIN_VALUE});
	}

	@Test
	public void testCase006() {
		testArrayDelete(new int[]{3, 8, 12, 5, 6}, 6, new int[]{3, 8, 12, 5, Integer.MIN_VALUE});
	}

	@Test
	public void testCase007() {
		testArrayDelete(new int[]{3, 8, 12, 5, 6}, 3, new int[]{8, 12, 5, 6, Integer.MIN_VALUE});
	}

	@Test
	public void testCase008() {
		testArrayLargest(new int[]{3, 12, 6, 5, 8}, 1);
	}

	@Test
	public void testCase009() {
		testArrayLargest(new int[0], -1);
	}

	@Test
	public void testCase010() {
		testArrayLargest(new int[]{3, 12, 4, 12, 5}, 1);
	}

	@Test
	public void testCase011() {
		testArraySecondLargest(new int[]{5, 10, 8, 20}, 1);
	}

	@Test
	public void testCase012() {
		testArraySecondLargest(new int[]{5, 10, 8, 20, 25, 56}, 4);
	}

	@Test
	public void testCase013() {
		testArraySecondLargest(new int[]{5, 5, 5, 5}, -1);
	}

	@Test
	public void testCase014() {
		testArraySorted(new int[]{8, 10, 12, 14}).isTrue();
	}

	@Test
	public void testCase015() {
		testArraySorted(new int[]{8, 10, 10, 14}).isTrue();
	}

	@Test
	public void testCase016() {
		testArraySorted(new int[]{8, 10}).isTrue();
	}

	@Test
	public void testCase017() {
		testArraySorted(new int[]{10, 8, 12, 14}).isFalse();
	}

	@Test
	public void testCase018() {
		testArraySorted(new int[]{100}).isTrue();
	}

	@Test
	public void testCase019() {
		testArrayReverse(new int[]{1, 2, 3, 4, 5}, new int[]{5, 4, 3, 2, 1});
	}

	@Test
	public void testCase020() {
		testArrayReverse(new int[]{1, 2, 3, 4}, new int[]{4, 3, 2, 1});
	}

	@Test
	public void testCase021() {
		testArrayReverse(new int[]{1}, new int[]{1});
	}

	@Test
	public void testCase022() {
		testArrayRemoveDuplicate(
				new int[]{10, 20, 20, 30, 30, 30, 30},
				new int[]{10, 20, 30, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE},
				3
		);
	}

	@Test
	public void testCase023() {
		testArrayRemoveDuplicate(
				new int[]{10, 10, 10},
				new int[]{10, Integer.MIN_VALUE, Integer.MIN_VALUE},
				1
		);
	}

	@Test
	public void testCase024() {
		testArrayRemoveDuplicate(
				new int[]{10, 20, 30, 40, 50, 60, 70},
				new int[]{10, 20, 30, 40, 50, 60, 70},
				7
		);
	}

	@Test
	public void testCase025() {
		testArrayGetRidOfZeroes(
				new int[]{8, 5, 0, 10, 0, 2, 0, 9},
				new int[]{8, 5, 10, 2, 9, 0, 0, 0}
		);
	}

	@Test
	public void testCase026() {
		testArrayGetRidOfZeroes(
				new int[]{0, 0, 0, 10, 0},
				new int[]{10, 0, 0, 0, 0}
		);
	}

	@Test
	public void testCase027() {
		testArrayGetRidOfZeroes(
				new int[]{40, 20, 30, 10},
				new int[]{40, 20, 30, 10}
		);
	}

	@Test
	public void testCase028() {
		testArrayLeftRotateByOne(
				new int[]{1, 2, 3, 4, 5},
				new int[]{2, 3, 4, 5, 1}
		);
	}

	@Test
	public void testCase029() {
		testArrayLeftRotateByOne(
				new int[]{30, 5, 20},
				new int[]{5, 20, 30}
		);
	}

	@Test
	public void testCase030() {
		testArrayLeftRotateByOne(
				new int[]{1},
				new int[]{1}
		);
	}

	@Test
	public void testCase031() {
		testArrayLeftRotateByOne(
				new int[]{1, 2},
				new int[]{2, 1}
		);
	}

	@Test
	public void testCase032() {
		testArrayLeftRotateByK(
				new int[]{1, 2, 3, 4, 5},
				2,
				new int[]{3, 4, 5, 1, 2}
		);
	}

	@Test
	public void testCase033() {
		testArrayLeftRotateByK(
				new int[]{1, 2, 3, 4, 5},
				5,
				new int[]{1, 2, 3, 4, 5}
		);
	}

	@Test
	public void testCase034() {
		testArrayLeftRotateByK(
				new int[]{10, 5, 30, 15},
				3,
				new int[]{15, 10, 5, 30}
		);
	}

	@Test
	public void testCase035() {
		testArrayFindLeader(new int[]{7, 10, 4, 10, 6, 5, 2}, 10);
	}

	@Test
	public void testCase036() {
		testArrayFindLeader(new int[]{10, 20, 30}, 30);
	}

	@Test
	public void testCase037() {
		testArrayFindLeader(new int[]{30, 20, 10}, 30);
	}

	@Test
	public void testCase038() {
		testArrayMaximumDifference(new int[]{2, 3, 10, 6, 4, 8, 1}, 8);
	}

	@Test
	public void testCase039() {
		testArrayMaximumDifference(new int[]{7, 9, 5, 6, 3, 2}, 2);
	}

	@Test
	public void testCase040() {
		testArrayMaximumDifference(new int[]{10, 20, 30}, 20);
	}

	@Test
	public void testCase041() {
		testArrayMaximumDifference(new int[]{30, 10, 8, 2}, -2);
	}

	/*----------------------------------------------- Private Methods ------------------------------------------------*/

	private void testArrayInsert(int[] array, int n, int capacity, int element, int position, int[] expectedArray) {
		int newSize = ArrayUtils.insert(array, n, element, capacity, position);
		Truth.assertThat(expectedArray).isEqualTo(array);
	}

	private void testArrayDelete(int[] array, int element, int[] expectedArray) {
		int newSize = ArrayUtils.delete(array, array.length, element);
		Truth.assertThat(expectedArray).isEqualTo(array);
		Truth.assertThat(newSize).isEqualTo(expectedArray.length - 1);
	}

	private void testArrayLargest(int[] array, int expectedIndex) {
		Truth.assertThat(ArrayUtils.largest(array)).isEqualTo(expectedIndex);
	}

	private void testArraySecondLargest(int[] array, int expectedIndex) {
		Truth.assertThat(ArrayUtils.secondLargest(array)).isEqualTo(expectedIndex);
	}

	private BooleanSubject testArraySorted(int[] array) {
		return Truth.assertThat(ArrayUtils.isSorted(array));
	}

	private void testArrayReverse(int[] array, int[] reverse) {
		ArrayUtils.reverse(array);
		Truth.assertThat(array).isEqualTo(reverse);
	}

	private void testArrayRemoveDuplicate(int[] array, int[] expected, int expectedSize) {
		int size = ArrayUtils.removeDuplicate(array);
		Truth.assertThat(array).isEqualTo(expected);
		Truth.assertThat(size).isEqualTo(expectedSize);
	}

	private void testArrayGetRidOfZeroes(int[] array, int[] expected) {
		ArrayUtils.getRidOfZeroes(array);
		Truth.assertThat(array).isEqualTo(expected);
	}

	private void testArrayLeftRotateByOne(int[] array, int[] expected) {
		ArrayUtils.leftRotateByOne(array);
		Truth.assertThat(array).isEqualTo(expected);
	}

	private void testArrayLeftRotateByK(int[] array, int k, int[] expected) {
		ArrayUtils.leftRotateByK(array, k);
		Truth.assertThat(array).isEqualTo(expected);
	}

	private void testArrayFindLeader(int[] array, int expected) {
		Truth.assertThat(ArrayUtils.findLeader(array)).isEqualTo(expected);
	}

	private void testArrayMaximumDifference(int[] array, int expected) {
		Truth.assertThat(ArrayUtils.maximumDifference(array)).isEqualTo(expected);
	}

}
