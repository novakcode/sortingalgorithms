package com.sorting;

import java.util.Arrays;



/**
 * Implementation of BubbleSort algorithm in Java.This is not optimized version.
 * 
 * Bubble Sort compares two elements and swaps them if the first one is greater then second one.
 */
public class BubbleSort implements Sort{

	public <T extends Comparable<T>> void sort(T[] arr) {
		bubbleSort(arr);
	}
	
	private <T extends Comparable<T>> void bubbleSort(T[] arr)
	{
		
		for(int a = 0; a  < arr.length - 1; a++){
			for(int b = 0; b < arr.length - 1; b++ ){
				if(arr[a].compareTo(arr[b + 1]) > 0 && a < b + 1){
					swapElements(arr,a,b + 1);
				}
			}
		}
			
		
	}
	
	
	
	public static void main(String[] args) {
		Integer[] numberArr = new Integer[] { 2,5,6,1,1,2,5,66,1,0,55,5,22,1,6,7};
		String[] stringArr = new String[] {"Novak","Nemanja","Joca","Ogi","Ana","Basta"};
		 
		BubbleSort bubbleSort = new BubbleSort();
		
		bubbleSort.bubbleSort(numberArr);
		bubbleSort.bubbleSort(stringArr);
		
		System.out.println(Arrays.toString(numberArr));
		System.out.println(Arrays.toString(stringArr));
	
	}

	
	
}
