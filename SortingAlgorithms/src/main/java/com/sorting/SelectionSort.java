package com.sorting;

import java.util.Arrays;

/**
 * Implementation of SelectionSort algorithm in Java.
 */
public class SelectionSort implements Sort {

	/*
	 * * SelectionSort picks smallest element in array[0...n] and puts it a
	 * start of array. Then it does same thing again for other part of
	 * array[1...n]
	 *
	 * NOTE: This is not best implementation,as it takes more nanoseconds to
	 * complete(around 1000);
	 * 
	 */

	@Override
	public <T extends Comparable<T>> void sort(T[] arr) {
		selectionSort(arr);

	}

	private <T extends Comparable<T>> void selectionSort(T[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = arr.length; j > i; j--) {
				swapElements(arr, j, j - 1);
			}
		}
	}

	public static void main(String[] args) {
		Integer[] numberArr = new Integer[] { 2, 5, 6, 1, 1, 2, 5, 66, 1, 0, 55, 5, 22, 1, 6, 7 };
		String[] stringArr = new String[] { "Novak", "Nemanja", "Joca", "Ogi", "Ana", "Basta" };

		SelectionSort selectionSort = new SelectionSort();

		selectionSort.sort(numberArr);
		selectionSort.sort(stringArr);

		System.out.println(Arrays.toString(numberArr));
		System.out.println(Arrays.toString(stringArr));
	}

}
