package com.sorting;

import java.util.Arrays;

/**
 * Implementation of InsertionSort algorithm in Java.
 * 
 * 
 */
public class InsertionSort implements Sort {

	/*
	 * InsertionSort sorts elements like we sort cards in our hand.
	 *
	 * 4 7 3 5 
	 * 3 4 7 5 
	 * 3 4 5 7
	 * 
	 */

	@Override
	public <T extends Comparable<T>> void sort(T[] arr) {
		insertionSort(arr);
	}

	private <T extends Comparable<T>> void insertionSort(T[] arr) {

		for (int i = 1; i < arr.length; i++) {

			T element = arr[i];
			int position = i - 1;

			for (int before = position; before >= 0; before--) {

				if (element.compareTo(arr[before]) < 0) {
					arr[before + 1] = arr[before];
					position = before;
				} else {
					position = before + 1;
					break;

				}
			}

			arr[position] = element;

		}
	}

	public static void main(String[] args) {
		Integer[] numberArr = new Integer[] { 2, 5, 6, 1, 1, 2, 5, 66, 1, 0, 55, 5, 22, 1, 6, 7 };
		String[] stringArr = new String[] { "Novak", "Nemanja", "Joca", "Ogi", "Ana", "Basta" };

		InsertionSort insertionSort = new InsertionSort();

		insertionSort.sort(numberArr);
		insertionSort.sort(stringArr);

		System.out.println(Arrays.toString(numberArr));
		System.out.println(Arrays.toString(stringArr));

	}

}
