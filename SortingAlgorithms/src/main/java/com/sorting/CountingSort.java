package com.sorting;


// Needs update
public class CountingSort implements Sort {

	@Override
	public <T extends Comparable<T>> void sort(T[] arr) {

		countingSort((Integer[]) arr);
	}

	private <T extends Comparable<T>> void countingSort(Integer[] arr) {

		Integer len = arr[0]; // Largest in array

		for (int i = 1; i < arr.length; i++) {
			if (len < arr[i])
				len = arr[i];
		}

		Integer[] arr1 = new Integer[len + 1]; // Count

		for (int i = 0; i <= len; i++) {

			int numOf = 0;

			for (int y = 0; y < arr.length; y++) {
				if (arr[y] == i)
					numOf++;
			}

			arr1[i] = numOf;
		}

		Integer[] arr2 = new Integer[arr1.length]; // Positions
		arr2[0] = arr1[0];

		for (int i = 1; i < arr1.length; i++) {
			arr2[i] = arr2[i - 1] + arr1[i];
		}

		

		for (int i = 0; i < arr1.length; i++) {
			for (int y = 0; y < arr1[i]; y++) {
				arr[arr2[i] - 1 - y] = i;
			}
		}

	}
	

	public static void main(String[] args) {
		Integer[] nums =new Integer[]{2,4,5,2,6,1,2,7,256};
		
		CountingSort cs = new CountingSort();
		
		cs.sort(nums);
		
		
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
	}

}
