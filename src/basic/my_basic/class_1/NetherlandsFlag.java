package basic.my_basic.class_1;

public class NetherlandsFlag {
	
	public static int[] partition(int[] arr, int l, int r, int num) {
		
		int less= l-1;
		int more = r+1;
		while (l < more) {
			if (arr[l] < num) {
				swap(arr, ++less, l++);
			}else if (arr[l]>num) {
				swap(arr,--more,l);
			}else {
				l++;
			}
		}
		return new int[] {less + 1 , more - 1};
	}
	
	
	private static void swap(int[] arr, int i, int j) {
		int tmp;
		tmp = arr[i];
		arr[i]=arr[j];
		arr[j]=tmp;		
	}

	//对数器
	public static int[] generateRandomArray(int maxSize,int maxValue) {
		int[] arr = new int[(int) ((maxSize+1)*Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue+1)* Math.random() - (maxValue+1)*Math.random());
		}
		return arr;
	}
	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {		
		int maxSize=10;
		int maxValue=5;
		int[] arr = generateRandomArray(maxSize, maxValue);
		printArray(arr);
		
		int[] res = partition(arr, 0, arr.length-1, arr[arr.length-1]);
		printArray(arr);
		System.out.println(res[0]);
		System.out.println(res[1]);
		
	}


	
}
