package com.sorting;

/**
 * Generic method for each sorting algorithm class
 * 
 */

public interface Sort {
	
	<T extends Comparable<T>> void sort(T[] arr);

	default <T> void swapElements(T[] arr, int lowPos, int highPos) {

		T temporaryValue = arr[lowPos];
		arr[lowPos] = arr[highPos];
		arr[highPos] = temporaryValue;

	}
	
	
	
}
