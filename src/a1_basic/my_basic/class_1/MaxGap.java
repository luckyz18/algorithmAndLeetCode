package a1_basic.my_basic.class_1;

import java.util.Arrays;

public class MaxGap {

	/*给定一个数组，求如果排序之后，相邻两数的最大差值，要求时 间复杂度O(N)，且要求不能用非基于比较的排序*/
	
	public static int maxGap(int[] arr) {
		if (arr == null || arr.length < 2) {
			return 0;
		}
		//获取最小值 最大值
		int len = arr.length;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			min = Math.min(min, arr[i]);
			max = Math.max(max, arr[i]);
		}
		if (min == max) {
			return 0;
		}
		//放到桶里
		boolean[] hasNum = new boolean[len + 1];
		int[] mins = new int[len + 1];
		int[] maxs = new int[len + 1];
		
		int bid = 0;
//		for (int i = 0; i < arr.length; i++) {
//			bid = bucket(arr[i], len, min, max);
//			hasNum[bid] = true;
//			mins[bid] = Math.min(mins[bid], arr[i]);
//			maxs[bid] = Math.max(maxs[bid], arr[i]);		
//		}
		for (int i = 0; i < len; i++) {
			bid = bucket(arr[i], len, min, max);
			mins[bid] = hasNum[bid] ? Math.min(mins[bid], arr[i]) : arr[i];
			maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], arr[i]) : arr[i];
			hasNum[bid] = true;
		}
		
		//找最大间距
		//多准备一个桶 这样最大间隙及排除了在一个桶内产生的情况
		//仅是求最大 gap 多放了一个桶 跟桶排序没有关系
		int res =0;
		int m = maxs[0];
		for(int i=1 ;i <= len;i++) {
			if (hasNum[i]) {
				res = (mins[i] - m)>res ? (mins[i] - m) : res;
				m = maxs[i];
			}
		}
		return res;

	}
	
	//放到几号桶里
	public static int bucket(long num, long len, long min, long max) {
		return (int) ((num - min) * len / (max - min));
	}
	
	//对数器
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
		}
		return arr;
	}
	public static int comparetor(int[] arr) {
		if (arr==null || arr.length < 2) {
			return 0;
		}
		Arrays.sort(arr);
//		printArray(arr);
		int res=0;
		for (int i = 1; i < arr.length; i++) {
			res = (arr[i] - arr[i-1]) > res? (arr[i] - arr[i-1]) :res;
		}
		return res;
	}
	
	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	public static int[] copyArray(int[] arr) {
		if (arr == null) {
			return null;
		}
		int[] res = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			res[i] = arr[i];
		}
		return res;
	}

	public static void main(String[] args) {
		int maxSize =10;
		int maxValue = 50;
		boolean succeed = true;
		int[] arr1 = generateRandomArray(maxSize, maxValue);
		printArray(arr1);		
		int res = maxGap(arr1);
		
		int[] arr2 = copyArray(arr1);
		int res2 = comparetor(arr2);
		if (res != res2) {
			printArray(arr1);
			printArray(arr2);
			System.out.println(res);
			System.out.println(res2);
			
		}else {
			System.out.println("nice!");
		}
		
	}

}
