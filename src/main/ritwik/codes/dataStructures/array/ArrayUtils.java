package ritwik.codes.dataStructures.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

/**
 * Collection of different problem statements wrapped around an Array.
 *
 * @author ritwikjamuar
 */
public class ArrayUtils {

	/*------------------------------------------------ Public Methods ------------------------------------------------*/

	/**
	 * Inserts an element in the array.
	 * <br/><br/>
	 * <pre>
	 * Example:
	 * {@code
	 *               0   1   2   3   4   5   6   7
	 *               1   5   9  13  17  21   *   *       <= array
	 * 
	 * insert(25, 3)
	 *               1   5   9  13  17  21   *   *       <= array
	 *                       |
	 *                 Insertion Point
	 * 
	 * =>            1   5   25  9  13  17  21   *       <= array
	 * }
	 * </pre>
	 * <b>Time Complexity Analysis:</b>
	 * <br/>
	 * <ul>
	 *     <li>
	 *         Best Case: <b>O(1)</b> (when we insert at the end of {@code array}).
	 *     </li>
	 *     <li>
	 *         Worst Case: <b>O(n)</b> (when we insert at the start of {@code array}).
	 *     </li>
	 *     <li>
	 *         Average Case: <b>O(n)</b>
	 *     </li>
	 * </ul>
	 *
	 * @param array    Array of {@link Integer} onto which we wish to insert {@code x}.
	 * @param n        Size of elements in {@code array}.
	 * @param x        {@link Integer} which we wish to insert into {@code array}.
	 * @param capacity Current Capacity of {@code array}.
	 * @param position Position onto which we wish to insert.
	 * @return Size of the modified array.
	 */
	public static int insert(int[] array, int n, int x, int capacity, int position) {

		// Halt the further execution if the array is either null or empty by returning 0 as the size.
		if (array == null || array.length == 0)
			return 0;

		// If the current capacity matches the size of array, then insertion is simply not possible
		// since there's no extra space left in the array for insertion.
		// So, we halt the further execution and simply return the current size of array.
		if (n == capacity)
			return n;

		// At this point, it is determined that there are some extra space available for insertion.

		int index = position - 1;

		// Shift the elements one by one from the insertion index
		// so that insertion can be done in the position conveniently,
		// Example:-
		//             0   1   2    3   4   5   6
		//             5   3   7   10  20   *   *                 <= array
		//                                                      4 <= insertion element
		//                 |                                    2 <= insertion index
		// Iteration #1:
		//             5   3   7   10  *   20   *                 <= array
		//                             |____|
		// Iteration #2:
		//             5   3   7   *   10  20   *                 <= array
		//                         |____|
		// Iteration #3:
		//             5   3   *   7   10  20   *                 <= array
		//                     |___|
		// Iteration #4:
		//             5   *   3   7   10  20   *                 <= array
		//                 |___|
		for (int i = n - 1; i >= index; --i) {
			array[i + 1] = array[i];
		}

		// Once all the other elements in array are shifted, then simply insert the element at the provided index.
		// Example:-
		//             5   *   3   7   10  20   *                 <= array
		//             5   4   3   7   10  20   *                 <= array
		array[index] = x;

		// Since the insertion is complete, we can say the size of array increased by 1.
		return (n + 1);

	}

	/**
	 * Deletes an element from the array.
	 * <pre>
	 * Example:
	 * {@code
	 *               0   1   2   3   4   5   6   7
	 *               1   5   9  13  17  21   *   *       <= array
	 *
	 * delete(9)
	 *               1   5   9  13  17  21   *   *       <= array
	 *                       |
	 *                 Deletion Point
	 *
	 * =>            1   5  13  17  21   *   *   *       <= array
	 * }
	 * </pre>
	 * <br/><br/>
	 * <b>TIme Complexity Analysis:</b>
	 * <ul>
	 *     <li>
	 *         Best Case: <b>O(1)</b> (when we delete at the end of {@code array}).
	 *     </li>
	 *     <li>
	 *         Worst Case: <b>O(n)</b> (when we delete at the start  of {@code array}).
	 *     </li>
	 *     <li>
	 *         Average Case: <b>O(n)</b>
	 *     </li>
	 * </ul>
	 *
	 * @param array Array of {@link Integer} onto which we wish to delete {@code x}.
	 * @param n     {@link Integer} denoting the size of {@code array}.
	 * @param x     {@link Integer} denoting the element we wish to delete.
	 * @return Size of the modified array.
	 */
	public static int delete(int[] array, int n, int x) {

		// Search for the element in the array.
		int index = search(array, x);

		// If the index we searched for turns out to be -1, it means that the item is not found.
		// So, we halt the further execution and return current size of array
		if (index == -1)
			return n;

		// Shift the elements one by one from deletion index.
		// Example:-
		//             0   1   2    3   4
		//             5   3   7   10  20                          <= array
		//                                                       3 <= deletion element
		// Iteration #1:
		//             5   7   7   10  20                          <= array
		//                 |___|
		// Iteration #2:
		//             5   7   10  10  20                          <= array
		//                      |___|
		// Iteration #3:
		//             5   7   10  20  20                          <= array
		//                          |___|
		for (int i = index; i < array.length - 1; ++i) {
			array[i] = array[i + 1];
		}

		// Since an element has been removed from middle of an array,
		// thus the last position element would be a duplicate value.
		// To remove this duplicate value, we replace it by another extreme value.
		// Example:-
		//             5   7   10  20  20                          <= array
		//             5   7   10  20   *                          <= array
		// NOTE: * indicates extreme value of your choice.
		array[array.length - 1] = Integer.MIN_VALUE;

		return (n - 1);

	}

	/**
	 * Finds the largest element in the {@code array}.
	 * <pre>
	 * Example:-
	 * {@code
	 *              0   1   2   3   4   5   6   7
	 *              2  17   7  21  10  30   1   9        <= array
	 *                                  |
	 *                               Largest
	 * }
	 * </pre>
	 *
	 * @param array Array of {@link Integer} onto which we perform the search.
	 * @return Position of the largest element if found, else {@code -1}.
	 * @see ArrayUtils#findLargestApproach00
	 * @see ArrayUtils#findLargestApproach01
	 */
	public static int largest(int[] array) {
		return findLargestApproach01(array);
	}

	/**
	 * Finds the second-largest element in the {@code array}.
	 * <pre>
	 * Example:-
	 * {@code
	 *              0   1   2   3   4   5   6   7
	 *              2  17   7  21  10  30   1   9        <= array
	 *                          |
	 *                    Second Largest
	 * }
	 * </pre>
	 *
	 * @param array Array of {@link Integer} onto which we perform the search.
	 * @return Position of the second-largest element if found, else {@code -1}.
	 * @see ArrayUtils#findSecondLargestApproach00
	 * @see ArrayUtils#findSecondLargestApproach01
	 * @see ArrayUtils#findSecondLargestApproach02
	 */
	public static int secondLargest(int[] array) {
		return findSecondLargestApproach02(array);
	}

	/**
	 * Search the {@code array} for a given {@code element}.
	 *
	 * @param array   Array of {@link Integer} onto which we perform the search.
	 * @param element {@link Integer} as our search candidate.
	 * @return Index of the {@code element} if found, else {@code -1}.
	 * @see ArrayUtils#linearSearch
	 */
	public static int search(int[] array, int element) {
		return linearSearch(array, element);
	}

	/**
	 * Checks whether a given {@code array} is sorted or not.
	 *
	 * @param array Array of {@link Integer} for which we want to check.
	 * @return {@code true} if the  {@code array} is sorted, else {@code false}.
	 * @see ArrayUtils#isSortedApproach00
	 */
	public static boolean isSorted(int[] array) {
		return isSortedApproach00(array);
	}

	/**
	 * Reverse a given {@code array}.
	 * <pre>
	 * Example:-
	 * {@code
	 *            0   1   2   3   4   5
	 *            8  34   5  72  83   1           <= array
	 *  =>        1  83  72   5  34   8
	 * }
	 * </pre>
	 *
	 * @param array Array of {@link Integer} which we want to reverse.
	 * @see ArrayUtils#reverseArrayApproach00
	 */
	public static void reverse(int[] array) {
		reverseArrayApproach00(array);
	}

	/**
	 * Remove Duplicate Elements from a sorted {@code array}.
	 * <pre>
	 * Example:-
	 * {@code
	 *           0   1   2   3   4   5   6   7
	 *          10  20  20  20  30  30  30  30       <= array
	 * =>       10  20  30   *   *   *   *   *
	 * }
	 * </pre>
	 *
	 * @param array Sorted Array of {@link Integer} from which we wish to remove duplicates.
	 * @return Modified Size of {@code array}.
	 * @see ArrayUtils#removeDuplicatesApproach00
	 * @see ArrayUtils#removeDuplicatesApproach01
	 */
	public static int removeDuplicate(int[] array) {
		return removeDuplicatesApproach00(array);
	}

	/**
	 * Remove {@code 0} from the {@code array} and maintain the insertion order of non-zero elements.
	 * <pre>
	 * Example:-
	 * {@code
	 *           0   1   2   3   4   5   6   7
	 *           8   5   0  10   0   2   0   9          <= array
	 *  =>       8   5  10   2   9   *   *   *
	 * }
	 * </pre>
	 *
	 * @param array Array of {@link Integer} onto which we wish to remove {@code 0}.
	 * @see ArrayUtils#getRidOfZeroesApproach00
	 * @see ArrayUtils#getRidOfZeroesApproach01
	 */
	public static void getRidOfZeroes(int[] array) {
		getRidOfZeroesApproach01(array);
	}

	/**
	 * Rotates the {@code array} to the left by the offset of {@code 1}.
	 * <pre>
	 * Example:-
	 * {@code
	 *           0   1   2   3   4
	 *           2   3   5   7  11                 <= array
	 *  =>      11   2   3   5   7
	 * }
	 * </pre>
	 *
	 * @param array Array of {@link Integer} which we wish to rotate.
	 * @see ArrayUtils#leftRotateByOneApproach00
	 */
	public static void leftRotateByOne(int[] array) {
		leftRotateByOneApproach00(array);
	}

	/**
	 * Rotates the {@code array} to the left by the offset of {@code k}.
	 * <pre>
	 * Example:-
	 * {@code
	 *           0   1   2   3   4
	 *           2   3   5   7  11                 <= array
	 *
	 * rotate(array, 3)
	 *  =>       5   7  11   2   3
	 * }
	 * </pre>
	 *
	 * @param array Array of {@link Integer} which we wish to rotate.
	 * @param k     Offset value
	 * @see ArrayUtils#leftRotateByKApproach00
	 * @see ArrayUtils#leftRotateByKApproach01
	 * @see ArrayUtils#leftRotateByKApproach02
	 */
	public static void leftRotateByK(int[] array, int k) {
		leftRotateByKApproach02(array, k);
	}

	/**
	 * Finds a leader from {@code array}.
	 * <br/><br/>
	 * <b>NOTE:</b> A Leader is an element in the {@code array} where all other items on the right of leader
	 * are smaller.
	 *<br/><br/>
	 * Examples:-
	 * <pre>{@code
	 * 1.
	 *                0   1   2   3   4   5   6   7
	 *                7  10   4  10   6   2   5   3
	 *                            *
	 *                         Leader
	 * }
	 * </pre>
	 * <pre>{@code
	 * 2.
	 *                0   1   2   3   4
	 *               10  10  10  10  10     ### NO LEADER since all the elements in array are same.
	 *
	 * }
	 * </pre>
	 *
	 * @param array Array of {@link Integer} in which we wish to find the leader.
	 * @return Leader Element if found, else {@code -1}.
	 * @see ArrayUtils#findLeaderApproach00
	 * @see ArrayUtils#findLeaderApproach01
	 */
	public static int findLeader(int[] array) {
		return findLeaderApproach01(array);
	}

	/**
	 * Finds the maximum difference between two elements of {@code array} such that:
	 * <pre>
	 * {@code max(array[j] - array[i])}     where i < j
	 * </pre>
	 * <pre>
	 * Example #1:
	 *
	 * {@code
	 *             0   1   2   3   4   5
	 *             2   3  10   6   8   4
	 *             *       *
	 * }
	 *
	 * Here, i = 0 & j = 2, which makes array[j] = 10 & array[i] = 2.
	 * So, 10 - 2 = 8 is the answer.
	 *
	 * Example #2:
	 *
	 * {@code
	 *             0   1   2   3
	 *            30  10   8   2
	 *                 *   *
	 * }
	 *
	 * In this case, the array is reverse sorted, so we'll encounter negative value for all indices.
	 * The answer in this case will be the least negative difference.
	 * Here, i = 1 & j = 2, which makes array[j] = 8 & array[i] = 10.
	 * So, 8 - 10 = -2 is the answer.
	 * </pre>
	 *
	 * @param array Array of {@link Integer} in which we wish to find the maximum difference.
	 * @return Maximum Difference between two elements in the array.
	 * @see ArrayUtils#maximumDifferenceApproach00
	 * @see ArrayUtils#maximumDifferenceApproach01
	 */
	public static int maximumDifference(int[] array) {
		return maximumDifferenceApproach01(array);
	}

	/*----------------------------------------------- Private Methods ------------------------------------------------*/

	/**
	 * Performs Linear Search in a given {@code array}.
	 * <br/><br/>
	 * <b>Time Complexity Analysis:</b>
	 * <ul>
	 *     <li>
	 *         Best Case: <b>O(1)</b> (when the search candidate is found in first position).
	 *     </li>
	 *     <li>
	 *         Worst Case: <b>O(n)</b> (when the search candidate is found in last position).
	 *     </li>
	 *     <li>
	 *         Average Case: <b>O(n)</b>
	 *     </li>
	 * </ul>
	 *
	 * @param array   Array of {@link Integer} onto which we find the {@code element}.
	 * @param element {@link Integer} denoting the element we want to find.
	 * @return Position within {@code array} if found, else {@code -1}.
	 * @see ArrayUtils#search 
	 */
	private static int linearSearch(int[] array, int element) {

		// Halt the further execution if the array is either null or empty or the search candidate is itself null,
		// by returning found position as -1.
		if (array == null || array.length == 0)
			return -1;

		// Iterate over every element in the array.
		for (int i = 0; i < array.length; ++i) {

			// Check for every element with our search candidate whether it matches.
			if (element == array[i]) {

				// At this stage, the search candidate and the array element in the position matches,
				// so we halt the further execution and return the position.
				return i;

			}

		}

		// At this stage, we have traversed through all the elements in the array
		// and no element matches our search candidate.
		// So we return -1 indicating nothing found.
		return -1;

	}

	/**
	 * Finds the Largest Number from given {@code array}.
	 * <br/><br/>
	 * <b>Time Complexity Analysis:</b>
	 * <ul>
	 *     <li>
	 *         Average Case: <b>O(n)</b>
	 *     </li>
	 * </ul>
	 *
	 * @param array Array of {@link Integer} onto which we wish to find.
	 * @return Position of the largest value from {@code array} else {@code -1} if for some reason not found.
	 * @see ArrayUtils#largest 
	 */
	private static int findLargestApproach01(int[] array) {

		if (array.length == 0)
			return -1;

		int largest = array[0];
		int index = 0;

		for (int i = 1; i < array.length; ++i) {

			if (largest < array[i]) {
				largest = array[i];
				index = i;
			}

		}

		return index;

	}

	/**
	 * Finds the Largest Number from given {@code array}.
	 * <br/><br/>
	 * <b>Time Complexity Analysis:</b>
	 * <ul>
	 *     <li>
	 *         Average Case: <b>O(n^2)</b>
	 *     </li>
	 * </ul>
	 *
	 * @param array Array of {@link Integer} onto which we wish to find.
	 * @return Position of the largest value from {@code array} else {@code -1} if for some reason not found.
	 * @see ArrayUtils#largest 
	 */
	private static int findLargestApproach00(int[] array) {

		for (int i = 0; i < array.length; ++i) {

			boolean flag = true;

			for (int j = 0; j < array.length; ++j) {

				if (i == j)
					continue;

				if (array[j] > array[i]) {
					flag = false;
					break;
				}

			}

			if (flag)
				return i;

		}

		return -1;

	}

	/**
	 * Finds the Second-Largest Number from given {@code array}.
	 * <br/><br/>
	 * <b>Time Complexity Analysis:</b>
	 * <ul>
	 *     <li>
	 *         Average Case: <b>O(n)</b>
	 *     </li>
	 * </ul>
	 *
	 * @param array Array of {@link Integer} onto which we wish to find.
	 * @return Position of the second-largest value from {@code array} else {@code -1} if for some reason not found.
	 * @see ArrayUtils#secondLargest 
	 */
	private static int findSecondLargestApproach00(int[] array) {

		// If the size of array is 1 or less, it means there are no more elements to compare for second largest,
		// hence, there is no second largest for given array.
		// So, halt the further execution by returning -1 indicating no valid second largest.
		if (array.length <= 1)
			return -1;

		// If there are only two items in an array, second-largest is just one comparison.
		// So, we halt the further execution here and return the index of second-largest element of array.
		if (array.length == 2)
			return array[0] > array[1] ? 1 : 0;

		// At this stage, the size of array is more than 2, so we tread accordingly.

		int largest, largestIndex, secondLargest, secondLargestIndex;

		// Initially populate the largest and secondLargest and their respective index
		// based on which of first two element is greater.
		if (array[0] > array[1]) {
			largest = array[0];
			largestIndex = 0;
			secondLargest = array[1];
			secondLargestIndex = 1;
		} else {
			largest = array[1];
			largestIndex = 1;
			secondLargest = array[0];
			secondLargestIndex = 0;
		}

		// Iterate over the array starting from index 2.
		for (int i = 2; i < array.length; ++i) {

			// CASE 1: array[i] is greater than both largest and secondLargest.
			// In this case, modify both largest and secondLargest with their respective indices.
			if (array[i] > largest && array[i] > secondLargest) {
				secondLargest = largest;
				secondLargestIndex = largestIndex;
				largest = array[i];
				largestIndex = i;
			}

			// CASE 2: array[i] is smaller than largest but greater than secondLargest.
			// In this case, modify only secondLargest with its respective index.
			if (array[i] < largest && array[i] > secondLargest) {
				secondLargest = array[i];
				secondLargestIndex = i;
			}

		}

		// Check for duplicate values.
		// If there's case that all the elements in the array is same,
		// then a simple comparison between largest and secondLargest should be able to tell us.
		// If there are duplicate items, then telling second-largest number is moot,
		// so we halt the further execution and return -1 to indicate that there's no second-largest number.
		if (largest == secondLargest)
			return -1;

		// At this stage, it's clear that there's no duplicate values,
		// so we can safely return the computed index of secondLargest number.
		return secondLargestIndex;

	}

	/**
	 * Finds the Second-Largest Number from given {@code array}.
	 * <br/><br/>
	 * <b>Time Complexity Analysis:</b>
	 * <ul>
	 *     <li>
	 *         Average Case: <b>O(n)</b>
	 *     </li>
	 * </ul>
	 *
	 * @param array Array of {@link Integer} onto which we wish to find.
	 * @return Position of the second-largest value from {@code array} else {@code -1} if for some reason not found.
	 * @see ArrayUtils#secondLargest 
	 */
	private static int findSecondLargestApproach01(int[] array) {

		int largestIndex = largest(array);

		if (largestIndex == -1)
			return -1;

		int res = -1;

		for (int i = 0; i < array.length; ++i) {

			if (array[i] != array[largestIndex]) {

				if (res == -1) {
					res = i;
				} else if (array[i] > array[res]) {
					res = i;
				}

			}

		}

		return res;

	}

	/**
	 * Finds the Second-Largest Number from given {@code array}.
	 * <br/><br/>
	 * <b>Time Complexity Analysis:</b>
	 * <ul>
	 *     <li>
	 *         Average Case: <b>O(n)</b>
	 *     </li>
	 * </ul>
	 *
	 * @param array Array of {@link Integer} onto which we wish to find.
	 * @return Position of the second-largest value from {@code array} else {@code -1} if for some reason not found.
	 * @see ArrayUtils#secondLargest 
	 */
	private static int findSecondLargestApproach02(int[] array) {

		if (array.length <= 1)
			return -1;

		if (array.length == 2)
			return array[0] > array[1] ? 1 : 0;

		TreeMap<Integer, Integer> numberMap = new TreeMap<>();

		int num = array[0];
		numberMap.put(array[0], 0);

		boolean areElementsSame = true;

		for (int i = 1; i < array.length; ++i) {
			numberMap.put(array[i], i);
			if (array[i] != num) {
				areElementsSame = false;
			}
		}

		if (areElementsSame)
			return -1;

		numberMap.pollLastEntry();

		return numberMap.get(numberMap.lastKey());

	}

	/**
	 * Determines whether a given {@code array} is sorted or not.
	 * <br/><br/>
	 * <b>Time Complexity Analysis:</b>
	 * <ul>
	 *     <li>
	 *         Average Case: <b>O(n)</b>
	 *     </li>
	 * </ul>
	 *
	 * @param array Array of {@link Integer} for which we want to check.
	 * @return {@code true} if the  {@code array} is sorted, else {@code false}.
	 * @see ArrayUtils#isSorted 
	 */
	private static boolean isSortedApproach00(int[] array) {

		if (array.length <= 1)
			return true;

		if (array.length == 2)
			return array[0] < array[1];

		if (array[0] > array[1])
			return false;

		for (int i = 2; i < array.length - 1; ++i) {

			if (array[i] > array[i + 1])
				return false;

		}

		return true;

	}

	/**
	 * Reverse a given {@code array}.
	 * <br/><br/>
	 * <b>Time Complexity Analysis:</b>
	 * <ul>
	 *     <li>
	 *         Average Case: <b>O(n)</b>
	 *     </li>
	 * </ul>
	 *
	 * @param array Array of {@link Integer} which we want to revers.
	 * @see ArrayUtils#reverse(int[]) Reverse an Array 
	 */
	private static void reverseArrayApproach00(int[] array) {

		// If the size of array is 1 or less, there's no point to swap anything, so we halt the further execution.
		if (array.length <= 1)
			return;

		// If the size of array is 2, then we just simply swap 0th and 1st index and no further execution needed.
		if (array.length == 2) {
			swapElementInArray(array, 0, 1);
			return;
		}

		// Iterate over array such that we swap 1st and last on 1st iteration, 2nd and 2nd last on 2nd iteration
		// and so on.
		// Example:-
		//                0   1   2   3   4
		//                1   2   3   4   5           <= array
		// Iteration #1:
		//                1   2   3   4   5
		//                |_______________|
		//            =>  5   2   3   4   1           <= array
		// Iteration #2:
		//                5   2   3   4   1
		//                    |_______|
		//            =>  5   4   3   2   1           <= array
		for (int i = 0; i < array.length / 2; ++i) {
			swapElementInArray(array, i, array.length - 1 - i);
		}

	}

	/**
	 * Swaps elements in {@code array} with given position.
	 *
	 * @param array Array of {@link Integer} onto which we want to perform swap operation.
	 * @param start First Swap Index
	 * @param end   Second Swap Index
	 */
	private static void swapElementInArray(int[] array, int start, int end) {
		int p = array[start];
		array[start] = array[end];
		array[end] = p;
	}

	/**
	 * Remove Duplicate Elements from {@code array}.
	 * <br/><br/>
	 * <b>Time Complexity Analysis:</b>
	 * <ul>
	 *     <li>
	 *         Average Case: <b>O(n)</b>
	 *     </li>
	 * </ul>
	 * <b>Space Complexity Analysis:</b>
	 * <ul>
	 *     <li>
	 *         Average Case: <b>O(1)</b>
	 *     </li>
	 * </ul>
	 *
	 * @param array Array of {@link Integer} from which we wish to remove duplicates.
	 * @return Modified Size of {@code array}.
	 * @see ArrayUtils#removeDuplicate 
	 */
	private static int removeDuplicatesApproach00(int[] array) {

		if (array.length <= 1)
			return array.length;

		int num = array[0];
		int insertionIndex = 1;

		for (int i = 1; i < array.length; ++i) {
			if (num != array[i]) {
				num = array[i];
				array[insertionIndex++] = array[i];
			}
		}

		for (int i = insertionIndex; i < array.length; ++i) {
			array[i] = Integer.MIN_VALUE;
		}

		return insertionIndex;

	}

	/**
	 * Remove Duplicate Elements from {@code array}.
	 * <br/><br/>
	 * <b>Time Complexity Analysis:</b>
	 * <ul>
	 *     <li>
	 *         Average Case: <b>O(n)</b>
	 *     </li>
	 * </ul>
	 * <b>Space Complexity Analysis:</b>
	 * <ul>
	 *     <li>
	 *         Average Case: <b>O(n)</b>
	 *     </li>
	 * </ul>
	 *
	 * @param array Array of {@link Integer} from which we wish to remove duplicates.
	 * @return Modified Size of {@code array}.
	 * @see ArrayUtils#removeDuplicate 
	 */
	private static int removeDuplicatesApproach01(int[] array) {

		if (array.length <= 1)
			return array.length;

		int[] duplicate = new int[array.length];

		Arrays.fill(duplicate, Integer.MIN_VALUE);

		int num = array[0];
		int index = 0;
		duplicate[index++] = num;

		for (int i = 1; i < array.length; ++i) {
			if (num != array[i]) {
				num = array[i];
				duplicate[index++] = array[i];
			}
		}

		//noinspection ManualArrayCopy
		for (int i = 0; i < array.length; ++i) {
			array[i] = duplicate[i];
		}

		return index;

	}

	/**
	 * Get rid of {@code 0}s from {@code array} while maintaining the insertion order of non-{@code 0} numbers.
	 * <br/><br/>
	 * <b>Time Complexity Analysis:</b>
	 * <ul>
	 *     <li>
	 *         Average Case: <b>O(n)</b>
	 *     </li>
	 * </ul>
	 * <b>Space Complexity Analysis:</b>
	 * <ul>
	 *     <li>
	 *         Average Case: <b>O(n)</b>
	 *     </li>
	 * </ul>
	 *
	 * @param array Array of {@link Integer} from which we wish to remove duplicates.
	 * @see ArrayUtils#getRidOfZeroes
	 */
	private static void getRidOfZeroesApproach00(int[] array) {

		LinkedList<Integer> nonZeroNumbers = new LinkedList<>();

		// Iterate over array and add every non-zero numbers to the list.
		for (int num : array) {
			if (0 != num) {
				nonZeroNumbers.add(num);
			}
		}

		// If the size of list matches the size of array, it means there are no 0's in the array,
		// hence nothing needs to be done further.
		if (array.length == nonZeroNumbers.size())
			return;

		// Iterate over the list and assign the non-zero numbers in respective indices.
		for (int i = 0; i < nonZeroNumbers.size(); ++i) {
			array[i] = nonZeroNumbers.get(i);
		}

		// Fill the remaining indices with 0.
		for (int i = nonZeroNumbers.size(); i < array.length; ++i) {
			array[i] = 0;
		}

	}

	/**
	 * Get rid of {@code 0}s from {@code array} while maintaining the insertion order of non-{@code 0} numbers.
	 * <br/><br/>
	 * <b>Time Complexity Analysis:</b>
	 * <ul>
	 *     <li>
	 *         Average Case: <b>O(n)</b>
	 *     </li>
	 * </ul>
	 * <b>Space Complexity Analysis:</b>
	 * <ul>
	 *     <li>
	 *         Average Case: <b>O(1)</b>
	 *     </li>
	 * </ul>
	 *
	 * @param array Array of {@link Integer} from which we wish to remove duplicates.
	 * @see ArrayUtils#getRidOfZeroes
	 */
	private static void getRidOfZeroesApproach01(int[] array) {

		if (array.length <= 1)
			return;

		int insertionIndex = 0;

		// Iterate over array such that insert the non-zero numbers on the go.
		// Example:-
		//               0   1   2   3   4   5   6   7
		//               8   5   0  10   0   2   0   9           <= array
		// Iteration #1: i = 0, insertionIndex = 0
		//               8   5   0  10   0   2   0   9           <= array
		//               |
		//               *
		// Iteration #2: i = 1, insertionIndex = 1
		//               8   5   0  10   0   2   0   9           <= array
		//                   |
		//                   *
		// Iteration #3: i = 2, insertionIndex = 2
		//               8   5   0  10   0   2   0   9           <= array
		//                       |
		//                       *
		// Iteration #4: i = 3, insertionIndex = 2
		//               8   5   0  10   0   2   0   9           <= array
		//                           |
		//                       *
		//
		// =>            8   5  10  10   0   2   0   9           <= array
		//                           *
		// Iteration #5: i = 4, insertionIndex = 3
		//               8   5  10  10   0   2   0   9           <= array
		//                               |
		//                           *
		// Iteration #6: i = 5, insertionIndex = 3
		//               8   5  10  10   0   2   0   9           <= array
		//                                   |
		//                           *
		//
		// =>            8   5  10   2   0   2   0   9           <= array
		//                               *
		// Iteration #7: i = 6, insertionIndex = 4
		//               8   5  10   2   0   2   0   9           <= array
		//                                       |
		//                               *
		// Iteration #8: i = 7, insertionIndex = 4
		//               8   5  10   2   0   2   0   9           <= array
		//                                           |
		//                               *
		//
		// =>            8   5  10   2   9   2   0   9           <= array
		//                                   *
		// => insertionIndex = 5
		for (int i = 0; i < array.length; ++i) {
			if (array[i] != 0) {
				array[insertionIndex++] = array[i];
			}
		}

		// If the insertionIndex matches the size of array, it means there were no 0's in the array,
		// thus no further execution needed.
		if (insertionIndex == array.length)
			return;

		// At this stage, it can be implied that there are 0's in the array.
		// To make the shifting process consistent, we need to fill the remaining indices
		// starting from insertionIndex to be 0.
		// Example:-
		// Iteration #1: i = 5
		//               8   5  10   2   9   2   0   9           <= array
		//                                   |
		// =>            8   5  10   2   9   0   0   9           <= array
		// Iteration #2: i = 6
		//               8   5  10   2   9   0   0   9           <= array
		//                                       |
		// =>            8   5  10   2   9   0   0   9           <= array
		// Iteration #3: i = 7
		//               8   5  10   2   9   0   0   9           <= array
		//                                           |
		// =>            8   5  10   2   9   0   0   0           <= array
		for (int i = insertionIndex; i < array.length; ++i) {
			array[i] = 0;
		}

	}

	/**
	 * Left-Rotate the given {@code array} by {@code 1}.
	 * <br/><br/>
	 * <b>Time Complexity Analysis:</b>
	 * <ul>
	 *     <li>
	 *         Average Case: <b>O(n)</b>
	 *     </li>
	 * </ul>
	 * <b>Space Complexity Analysis:</b>
	 * <ul>
	 *     <li>
	 *         Average Case: <b>O(1)</b>
	 *     </li>
	 * </ul>
	 *
	 * @param array Array of {@link Integer} to be left-rotated by 1.
	 * @see ArrayUtils#leftRotateByOne
	 */
	private static void leftRotateByOneApproach00(int[] array) {

		// If the size of array is 1 or less, then rotation is not needed, so we halt execution here.
		if (array.length <= 1)
			return;

		// Since, we are going to rotate the array just by 1, so 1st element will be lost during shifting other elements
		// one by one, so we preserve the first element.
		int first = array[0];

		// Iterate over the array and
		for (int i = 1; i < array.length; ++i) {
			array[i - 1] = array[i];
		}

		array[array.length - 1] = first;

	}

	/**
	 * Left-Rotate the given {@code array} by {@code k}.
	 * <br/><br/>
	 * <b>Time Complexity Analysis:</b>
	 * <ul>
	 *     <li>
	 *         Average Case: <b>O(n)</b>
	 *     </li>
	 * </ul>
	 * <b>Space Complexity Analysis:</b>
	 * <ul>
	 *     <li>
	 *         Average Case: <b>O(n)</b>
	 *     </li>
	 * </ul>
	 *
	 * @param array Array of {@link Integer} to be rotated.
	 * @param k     Offset value
	 * @see ArrayUtils#leftRotateByK
	 */
	private static void leftRotateByKApproach00(int[] array, int k) {

		if (array.length <= 1)
			return;

		while (k > array.length)
			k -= array.length;

		if (array.length == k)
			return;

		List<Integer> list = new LinkedList<>();

		for (int i = k; i < array.length; ++i) {
			list.add(array[i]);
		}

		for (int i = 0; i < k; ++i) {
			list.add(array[i]);
		}

		for (int i = 0; i < array.length; ++i) {
			array[i] = list.get(i);
		}

	}

	/**
	 * Left-Rotate the given {@code array} by {@code k}.
	 * <br/><br/>
	 * <b>Time Complexity Analysis:</b>
	 * <ul>
	 *     <li>
	 *         Average Case: <b>O(n * k)</b>
	 *     </li>
	 * </ul>
	 * <b>Space Complexity Analysis:</b>
	 * <ul>
	 *     <li>
	 *         Average Case: <b>O(1)</b>
	 *     </li>
	 * </ul>
	 *
	 * @param array Array of {@link Integer} to be rotated.
	 * @param k     Offset value
	 * @see ArrayUtils#leftRotateByK
	 */
	private static void leftRotateByKApproach01(int[] array, int k) {

		while (k > array.length)
			k -= array.length;

		for (int i = 0; i < k; ++i) {
			leftRotateByOne(array);
		}

	}

	/**
	 * Left-Rotate the given {@code array} by {@code k}.
	 * <br/><br/>
	 * <b>Time Complexity Analysis:</b>
	 * <ul>
	 *     <li>
	 *         Average Case: <b>O(n)</b>
	 *     </li>
	 * </ul>
	 * <b>Space Complexity Analysis:</b>
	 * <ul>
	 *     <li>
	 *         Average Case: <b>O(1)</b>
	 *     </li>
	 * </ul>
	 *
	 * @param array Array of {@link Integer} to be rotated.
	 * @param k     Offset value
	 * @see ArrayUtils#leftRotateByK
	 */
	private static void leftRotateByKApproach02(int[] array, int k) {

		// First, we reverse from 0 to k - 1.
		// Example:-
		// k = 2
		//           0   1   2   3   4
		//           5   7   9  11  13              <= array
		//           *   *
		// =>        7   5   9  11  13
		reverse(array, 0, k - 1);

		// Second, we reverse from k to array size - 1.
		// Example:-
		// k = 2
		//           0   1   2   3   4
		//           7   5   9  11  13              <= array
		//                   *   *   *
		// =>        7   5  13  11   9
		reverse(array, k, array.length - 1);

		// Finally, we reverse from 0 to array size - 1.
		// Example:-
		// k = 2
		//           0   1   2   3   4
		//           7   5  13  11   9              <= array
		//           *   *   *   *   *
		// =>        9  11  13   5   7
		reverse(array, 0, array.length - 1);

	}

	/**
	 * Reverses the {@code array} in the range between {@code low} and {@code high}.
	 *
	 * @param array Array of {@link Integer} to which we wish to perform reversal.
	 * @param low   Lower Range
	 * @param high  Higher Range
	 */
	private static void reverse(int[] array, int low, int high) {
		while (low < high) {
			swapElementInArray(array, low, high);
			low += 1;
			high -= 1;
		}
	}

	/**
	 * Finds a leader from {@code array}.
	 * <br/><br/>
	 * <b>Time Complexity Analysis:</b>
	 * <ul>
	 *     <li>
	 *         Best Case: <b>O(n)</b> (when the {@code array} is sorted)
	 *     </li>
	 *     <li>
	 *         Worst Case: <b>O(n^2)</b> (when the {@code array} is unsorted and the leader is in second last)
	 *     </li>
	 *     <li>
	 *         Average Case: <b>O(n^2)</b>
	 *     </li>
	 * </ul>
	 *
	 * @param array Array of {@link Integer} in which we wish to find the leader.
	 * @return Leader Element if found, else {@code -1}.
	 * @see ArrayUtils#findLeader
	 */
	private static int findLeaderApproach00(int[] array) {

		if (isSorted(array))
			return array[array.length - 1];

		for (int i = 0; i < array.length - 1; ++i) {

			boolean areAllElementsSmall = true;

			for (int j = i + 1; j < array.length; ++j) {
				if (array[i] < array[j]) {
					areAllElementsSmall = false;
					break;
				}
			}

			if (areAllElementsSmall)
				return array[i];

		}

		return -1;

	}

	/**
	 * Finds a leader from {@code array}.
	 * <br/><br/>
	 * <b>Time Complexity Analysis:</b>
	 * <ul>
	 *     <li>
	 *         Average Case: <b>O(n)</b>
	 *     </li>
	 * </ul>
	 *
	 * @param array Array of {@link Integer} in which we wish to find the leader.
	 * @return Leader Element if found, else {@code -1}.
	 * @see ArrayUtils#findLeader
	 */
	private static int findLeaderApproach01(int[] array) {

		int currentLeader = array[array.length - 1];

		for (int i = array.length - 2; i >= 0; --i) {
			if (currentLeader < array[i]) {
				currentLeader = array[i];
			}
		}

		return currentLeader;

	}

	/**
	 * Finds the maximum difference from {@code array}.
	 * <br/><br/>
	 * <b>Time Complexity Analysis:</b>
	 * <ul>
	 *     <li>
	 *         Average Case: <b>O(n^2)</b>
	 *     </li>
	 * </ul>
	 *
	 * @param array Array of {@link Integer} in which we wish to find the maximum difference.
	 * @return Maximum Difference between two elements in the array.
	 * @see ArrayUtils#maximumDifference
	 */
	private static int maximumDifferenceApproach00(int[] array) {

		int maxDiff = Integer.MIN_VALUE;

		for (int i = 0; i < array.length - 1; ++i) {
			for (int j = i + 1; j < array.length; ++j) {
				if (maxDiff < array[j] - array[i]) {
					maxDiff = array[j] - array[i];
				}
			}
		}

		return maxDiff;

	}

	/**
	 * Finds the maximum difference from {@code array}.
	 * <br/><br/>
	 * <b>Time Complexity Analysis:</b>
	 * <ul>
	 *     <li>
	 *         Average Case: <b>O(n)</b>
	 *     </li>
	 * </ul>
	 *
	 * @param array Array of {@link Integer} in which we wish to find the maximum difference.
	 * @return Maximum Difference between two elements in the array.
	 * @see ArrayUtils#maximumDifference
	 */
	private static int maximumDifferenceApproach01(int[] array) {

		int res = array[1] - array[0];
		int minVal = array[0];

		for (int j = 1; j < array.length; ++j) {
			res = Math.max(res, array[j] - minVal);
			minVal = Math.min(minVal, array[j]);
		}

		return res;

	}

}
