package jianzhi_offer;

/**
 * 数组中出现次数超过一半的数字
 */
public class code_39 {

    public static int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int time = 1;
        int cur = array[0];
        for (int i = 1; i < array.length; i++) {
            if (time == 0) {
                time = 1;
                cur = array[i];
            } else if (array[i] == cur) {
                time++;
            } else {
                time--;
            }
        }
        return getNumMoreThanHalf(cur, array);
    }

    public static int getNumMoreThanHalf(int num, int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int count = 0;
        for (int a :
                arr) {
            if (a == num) {
                count++;
            }
        }
        if (count > (arr.length >> 1))
            return num;
        return 0;
    }

    //随机快排
    public static int MoreThanHalfNum_Solution2(int[] array) {
        int len = array.length;
        if (array == null || len == 0) {
            return 0;
        }
        int start = 0;
        int end = len - 1;
        int[] p = partation(array, start, end);
        while (!(p[0] <= len / 2 && p[1] >= len / 2)) {
            if (p[0] > len / 2) {
                end = p[0] - 1;
                p = partation(array, start, end);
            } else if (p[1] < len / 2) {
                start = p[1] + 1;
                p = partation(array, start, len - 1);
            }
        }
        return getNumMoreThanHalf(array[p[0]], array);
    }

    public static int[] partation(int[] arr, int l, int r) {
        swap(arr, l + (int) (Math.random() * (r - l + 1)), r);

        int less = -1;
        int more = r;
        while (l < more) {
            if (arr[l++] < arr[more]) {
                swap(arr, ++less, l++);
            } else if (arr[l++] > arr[more]) {
                swap(arr, --more, l);
            } else {
                l++;
            }
        }
        swap(arr, r, more);
        return new int[]{less + 1, more};
    }

    private static void swap(int[] arr, int i, int i1) {
        int tmp = arr[i];
        arr[i] = arr[i1];
        arr[i1] = tmp;
    }

    //---------------------------------
    public static int MoreThanHalfNum_Solution3(int[] array) {
        int len = array.length;
        if (array == null || len == 0) {
            return 0;
        }
        int start = 0;
        int end = len - 1;
        int index = partation3(array, start, end);
        while (index!= len/2){
            if (index < len/2){
                start = index+1;
                index = partation3(array, start, end);
            }else{
                end = index-1;
                index = partation3(array, start, end);
            }
        }
        return getNumMoreThanHalf(array[index], array);
    }
    public static int partation3(int[] arr, int l, int r) {
        swap(arr, l + (int) (Math.random() * (r - l + 1)), r);
        int base = arr[r];
        while (l < r){
            while (l < r && arr[l] <= base){
                l++;
            }
            if (l<r){
                arr[r--] = arr[l];
            }
            while (l<r && arr[r] >= base){
                r--;
            }
            if (l<r){
                arr[l++] = arr[r];
            }
        }
        arr[l] = base;
        return l;
    }


    public static void main(String[] args) {
        int i = MoreThanHalfNum_Solution2(new int[]{1,2,3,2,2,2,5,4,2});
        System.out.println(i);
    }
}
