package com.sorting;

import java.util.Arrays;

/**
 * Implementation of InsertionSort algorithm in Java.
 * 
 * InsertionSort sorts elements like we sort cards in our hand. You pick element
 * arr[q] and and check if its smaller than element a[q - 1] If it is, you move
 * element a[q - 1] to arr[q](At start you store element arr[q] so its value is
 * not lost). You loop through elements and move them by 1+ position until
 * arr[q] is not smaller.Then you you set our stored value from arr[q] at that
 * position. You do the same thing for every element in array.
 *
 */
public class InsertionSort implements Sort {

	@Override
	public <T extends Comparable<T>> void sort(T[] arr) {
		insertionSort(arr);
	}

	private <T extends Comparable<T>> void insertionSort(T[] arr){
		
		for(int i = 1; i < arr.length; i++){
			
			T element = arr[i];
			int position = i - 1;
			
			for(int before = position; before >= 0; before--){
				
				if(element.compareTo(arr[before]) < 0){
					arr[before + 1] = arr[before];
					position = before;
				}else{
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
