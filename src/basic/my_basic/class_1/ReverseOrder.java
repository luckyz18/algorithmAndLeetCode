package basic.my_basic.class_1;

public class ReverseOrder {
	
		//逆序对
		public static void reverseOrder(int[] arr) {
			if (arr==null || arr.length<2) {
				return ;
			}
			 mergeSort(arr,0,arr.length-1);
		}
		
		/*归并的思想*/
		public static int mergeSort(int[] arr, int l, int r) {		
			if (l == r) {
				return 0;
			}
			int mid = (l+r)/2;
			int k = mergeSort(arr, l, mid)+mergeSort(arr, mid+1, r)+merge(arr,l,mid,r);
			System.out.println("merge总逆序数："+k);
			return k;
		}

		public static int merge(int[] arr, int l, int mid, int r) {
			int merge_res=0;
			int[] help = new int[r - l + 1];   //help的长度不是一个大的N 而是每次分治 的长度
			int i=0;
			int p1 = l;
			int p2 = mid+1;
			
			while(p1 <= mid && p2 <= r) {
				if ( arr[p2] < arr[p1] ) {    //说明 p2 此时比p1中剩下的元素都小	
					merge_res += (mid-p1+1);  //核心 
				}
				help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++] ;
			}
			while(p1<=mid) {
				help[i++] = arr[p1++];
			}
			while (p2<=r) {
				help[i++] = arr[p2++];
				
			}
			//拷贝到 arr数组
			for (int j = 0; j < help.length; j++) {
				arr[l+j] = help[j];  //这里写错了 掉了 l
			}
			System.out.println("merge_res:"+merge_res);
			return merge_res;
		}

		//对数器  生成随机长度    随机值的数组
		public static int[] generateRamdomArray(int maxSize, int maxValue) {
			int[] array = new int[(int) ((maxSize+1)* Math.random())];
			for (int i = 0; i < array.length; i++) {
				array[i] = (int) ((maxValue+1)* Math.random()) - (int) ((maxValue+1)* Math.random());
			}
			return array;
			
		}
		
		//一个复杂度高但是正确的方法 for 测试另一种方法
		public static void comparator(int[] arr) {
			int comparator_res=0;
			for (int i = 1; i < arr.length; i++) {
				for (int j = 0; j < i; j++) {
					if (arr[j]>arr[i]) {
//						System.out.println(arr[j]+","+arr[i]);
						comparator_res++;
					}
				}
			}
			System.out.println("comparator_res："+ comparator_res);
		}
		//判断两个数组是否相等
		public static boolean isEqual(int[] arr1, int[] arr2) {
			
			if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
				return false;
			}
			if (arr1 == null && arr2 == null) {
				return true;
			}
			if (arr1.length != arr2.length) {
				return false;
			}
			for (int i = 0; i < arr2.length; i++) {
				if (arr1[i]!=arr2[i]) {
					return false;
				}
			}
			return true;
		}
		
		//复制数组
		public static int[] copyArrar(int[] arr) {
			if (arr == null) {
				return null;
			}
			int[] res = new int[arr.length];
			for (int i = 0; i < arr.length; i++) {
				res[i] = arr[i];
			}
			return res;
		}

		public static void printArray(int[] arr) {
			if (arr == null) {
				return;
			}
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}
		
		public static void main(String[] args) {
			int testTime = 5000;
			int maxSize = 10;
			int maxValue = 50;
			boolean flag = true;
			
			int[] arr1 = generateRamdomArray(maxSize, maxValue);
			int[] arr2 = copyArrar(arr1);
			
			printArray(arr1);
			System.out.println("----------------");

			comparator(arr2);
			System.out.println("============");
			reverseOrder(arr1);
			

			
		}
	}

