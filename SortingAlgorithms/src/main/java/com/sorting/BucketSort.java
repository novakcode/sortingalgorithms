package com.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Implementation of BucketSort algorithm in Java.<br/>
 * Note: Only works with int type
 * 
 *
 */
public class BucketSort implements Sort {

	/**
	 * 
	 * Bucket Sort works by creating a number of buckets and putting certain
	 * number elements from unsorted array into each bucket.Then it sorts each
	 * bucket with insertion sort(or any other sort).At end it puts element from each bucket into unsortedArray.
	 * That way we get a sorted array.
	 * 
	 **/

	@Override
	public <T extends Comparable<T>> void sort(T[] arr) {
		bucketSort(arr);

	}

	private <T extends Comparable<T>> void bucketSort(T[] arr) {

		/* 10 elements per bucket */
		int numberOfBuckets = (int) Math.ceil((double) arr.length / 10);

		/* Bucket list */
		List<List<T>> buckets = new ArrayList<List<T>>(numberOfBuckets);

		/* Fill list of buckets */
		for (int bucket = 0; bucket < numberOfBuckets; bucket++) {
			buckets.add(bucket, new ArrayList<T>());
		}

		/* Put elements in right bucket */
		for (int element = 0; element < arr.length; element++) {

			int validBucket = getValidBucket(arr[element], numberOfBuckets);

			buckets.get(validBucket).add(arr[element]);

		}

		/* We sort bucket and then put each element of bucket in arr */
		int index = 0;
		for (List<T> bucket : buckets) {
			insertionSort(bucket);
			for (T element : bucket) {
				arr[index++] = element;
			}
		}
	}

	/*
	 * Note: Not the best aproach to finding a right bucket.Better way would be
	 * getting the maximum and minimum element in array and using their
	 * difference and some other calculations to find right bucket.
	 */
	private <T> int getValidBucket(T currentElement, int numberOfBuckets) {

		int bucket = (int) Math.ceil((double) (Integer) currentElement / numberOfBuckets);

		if (bucket >= numberOfBuckets) {
			bucket = numberOfBuckets - 1;
		}
		return bucket;
	}

	/* Insertion Sort for sorting each bucket */
	private <T extends Comparable<T>> void insertionSort(List<T> arr) {

		for (int i = 1; i < arr.size(); i++) {

			T element = arr.get(i);
			int position = i - 1;

			for (int before = position; before >= 0; before--) {

				if (element.compareTo(arr.get(before)) < 0) {
					arr.set(before + 1, arr.get(before));
					position = before;
				} else {
					position = before + 1;
					break;

				}
			}

			arr.set(position, element);

		}
	}

	public static void main(String[] args) {
		Integer[] numberArr = new Integer[] { 2, 5, 6, 1, 1, 2, 5, 66, 1, 0, 55, 5, 22, 1, 6, 7, 1, 43, 18, 20, 3 };

		BucketSort bucketSort = new BucketSort();

		bucketSort.sort(numberArr);

		System.out.println(Arrays.toString(numberArr));

	}
}
