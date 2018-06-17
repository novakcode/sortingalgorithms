package com.sorting;

import java.util.Arrays;

/**
 * Implementation of QuickSort algorithm in Java. This version of QuickSort
 * picks first element as pivot.
 * 
 * How QuickSort works:<br/>
 * 1. Pick a pivot element <br/>
 * 2. Partition array into two sub arrays,so that first array is consisted of
 * elements that are less then pivot and second array consisted of elements that
 * are greater then pivot<br/>
 * 3. Using recursion do QuickSort on both sub arrays until they are sorted
 * 
 * 
 */

public class QuickSort implements Sort {

	public <T extends Comparable<T>> void sort(T[] arr) {
		quickSort(arr, 0, arr.length);
	}

	private <T extends Comparable<T>> void quickSort(T[] arr, int startPos, int endPos) {

		if (startPos < endPos) {
			int partition = partition(arr, startPos, endPos);

			quickSort(arr, startPos, partition);
			quickSort(arr, partition + 1, arr.length);
		}

	}

	private <T extends Comparable<T>> int partition(T[] arr, int startPos, int endPos) {

		T pivotElement = arr[startPos];
		int lowPos = startPos;

		for (int pos = startPos + 1; pos < endPos; pos++) {

			if (arr[pos].compareTo(pivotElement) <= 0) {
				lowPos++;

				swapElements(arr, pos, lowPos);
			}

		}

		swapElements(arr, startPos, lowPos);

		return lowPos;

	}

	

	/* Example */
	public static void main(String[] args) {
		Integer[] numberArr = new Integer[] { 2,5,6,1,1,2,5,66,1,0,55,5,22,1,6,7};
		String[] stringArr = new String[] {"Novak","Nemanja","Joca","Ogi","Ana","Basta"};
		
		QuickSort quickSort = new QuickSort();
		
		quickSort.sort(numberArr);
		quickSort.sort(stringArr);
		
		System.out.println(Arrays.toString(numberArr));
		System.out.println(Arrays.toString(stringArr));
		
	}

}
