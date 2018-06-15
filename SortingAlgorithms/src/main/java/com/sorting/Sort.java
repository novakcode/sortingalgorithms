package com.sorting;

/**
 * Generic method for each sorting algorithm class
 * 
 */

public interface Sort {
	
	<T extends Comparable<T>> void sort(T[] arr);
	
	
	
	
}
