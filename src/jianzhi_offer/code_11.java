package jianzhi_offer;

/**
 * 旋转数组中的最小值
 */
public class code_11 {
    public static int minNumberInRotateArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int r = array.length - 1;
        int l = 0;
        while (r > l) {
            int mid = ((r - l) >> 1) + l;
            if (array[mid] <= array[r]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return array[l];
    }
    public static int minNumberInRotateArray2(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int r = array.length - 1;
        int l = 0;
        while (r > l+1) {
            int mid = ((r - l) >> 1) + l;
            if (array[mid] > array[l]){
                l = mid;
                continue;
            } else {
                r = mid;
            }
        }
        return array[r];
    }


    public static void main(String[] args) {
        int i = minNumberInRotateArray2(new int[]{});
        System.out.println(i);
    }
}
