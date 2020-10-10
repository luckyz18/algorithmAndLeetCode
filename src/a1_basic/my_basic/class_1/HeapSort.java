package a1_basic.my_basic.class_1;

import java.util.Arrays;

public class HeapSort {
	
	public static void heapSort(int[] arr) {
		if (arr == null || arr.length <2) {
			return;
		}
		//建堆
		for (int i = 0; i < arr.length; i++) {
			heapInsert(arr,i);
		}
		int size = arr.length;
		swap(arr, 0, --size);
		
		/*调整堆*/
		while ( size > 0 ) {
			heapify(arr, 0, size);
			swap(arr, 0, --size);
		}
	}

	public static void heapInsert(int[] arr, int index) {
		while (arr[index] > arr[(index-1)/2]) {
			swap(arr,index,(index-1)/2);
			index = (index-1)/2;
		}
	}
	
	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
		
	}
	/**
	 * 调整堆
	 * @param arr
	 * @param index  要开始调整的位置
	 * @param heapSize  标记越界
	 */
	public static void heapify(int[] arr, int index, int heapSize) {
		int left = index * 2 + 1;
		while (left < heapSize) {
			int large = ((left+1) < heapSize && arr[left+1]>arr[left])
					? left+1
					: left;
			large = arr[large] > arr[index] ? large : index;
			if (large == index) {
				break;
			}
			swap(arr, large, index);
			index = large;
			left = index * 2 + 1;
		}
	}
	
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int) ((maxSize+1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue+1) * Math.random() - (maxValue) * Math.random());
		}
		return arr;
	}
	public static int[] copyArray(int[] arr1) {
		int[] arr2 = new int[arr1.length];
		for (int i = 0; i < arr1.length; i++) {
			arr2[i] = arr1[i];
		}
		return arr2;
		
	}
	public static void comparator(int[] arr2) {
		Arrays.sort(arr2);
		
	}
	public static boolean isEqual(int[] arr1, int[] arr2) {
		if ((arr1==null && arr2!=null) || ((arr1!=null && arr2==null))) {
			return false;
		}
		if (arr1.length != arr2.length) {
			return false;
		}
		for (int i = 0; i < arr2.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		int testTime = 500000;
		int maxSize = 100;
		int maxValue = 100;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copyArray(arr1);
			heapSort(arr1);
			comparator(arr2);
			if (!isEqual(arr1, arr2)) {
				succeed = false;
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");

	}

}
