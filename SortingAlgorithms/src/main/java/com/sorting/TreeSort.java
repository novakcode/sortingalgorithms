package com.sorting;

import java.util.ArrayList;
import java.util.List;

import com.sorting.TreeSort.Tree.Node;

public class TreeSort implements Sort {

	@Override
	public <T extends Comparable<T>> void sort(T[] arr) {
		treeSort(arr);

	}

	private <T extends Comparable<T>> void treeSort(T[] arr) {
		Node<T> root = Tree.fromList(arr);

		List<T> list = new ArrayList<T>();

		inOrderTraverse(root, list);

		list.toArray(arr);
	}

	private <T extends Comparable<T>> void inOrderTraverse(Node<T> node, List<T> list) {
		if (node == null)
			return;

		inOrderTraverse(node.left, list);

		list.add(node.getVal());

		inOrderTraverse(node.right, list);
	}

	protected static class Tree {

		static <T extends Comparable<T>> Node<T> fromList(T[] arr) {

			Node<T> node = null;

			for (int i = 0; i < arr.length; i++) {
				node = traverse(arr[i], node);
			}

			return node;
		}

		private static <T extends Comparable<T>> Node<T> traverse(T val, Node<T> node) {

			if (node == null)
				return new Node<T>(val);

			if (val.compareTo(node.getVal()) >= 0)
				node.right = traverse(val, node.right);
			else
				node.left = traverse(val, node.left);

			return node;
		}

		protected static class Node<T> {

			private T val;

			Node<T> left = null;
			Node<T> right = null;

			public Node(T val) {
				this.val = val;
			}

			public T getVal() {
				return val;
			}

		}

	}

	public static void main(String[] args) {
		TreeSort treeSort = new TreeSort();

		Integer[] arr = new Integer[] { 7, 4, 2, 1, 3, 55, 67, 14512512, 33, 3, 8, 0, 11 };
		treeSort.sort(arr);

		System.out.println();
		for (int i = 0; i < arr.length; i++)
			System.out.println(arr[i]);

	}

}
