package com.sorting;

public class ShellSort implements Sort {

	@Override
	public <T extends Comparable<T>> void sort(T[] arr) {
		shellSort(arr);

	}

	<T extends Comparable<T>> void shellSort(T[] arr) {

		int h = 1;

		while (h < arr.length / 3) {
			h = 3 * h + 1;
		}

		for (int s = h; s >= 1; s--, s /= 3) {

			for (int i = s; i < arr.length; i++) { // Sublists

				T key = arr[i];
				int y = i;

				for (y = i; y - s >= 0 && key.compareTo(arr[y - s]) < 0; y -= s) {

					arr[y] = arr[y - s];
				}

				arr[y] = key;

			}

		}
	}

	

}
