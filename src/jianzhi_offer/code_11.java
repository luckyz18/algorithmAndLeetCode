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
            if (array[l] == array[r] && array[mid] == array[l]){
                return minNumber(array, l, r);
            }
            if (array[mid] <= array[r]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return array[l];
    }

    private static int minNumber(int[] array, int l, int r) {
        int res = array[l];
        for (int i = l+1; i <=r ; i++) {
            if (array[i] < res){
                res = array[i];
            }
        }
        return res;
    }

    //ac 不过 没考虑 1 2 3 4  这种情况
    //还是没通过 不知什么鬼。。。
    //通过了
    public static int minNumberInRotateArray2(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int r = array.length - 1;
        int l = 0;
        int mid =l;
        while (array[l] >= array[r]) {
            if (r == l+1){
                mid = r;
                break;
            }
            mid = (l+r)/2;
            if (array[mid] >= array[l]){
                l = mid;
            } else {
                r = mid;
            }
        }
        return array[mid];
    }


    public static void main(String[] args) {
        int i = minNumberInRotateArray2(new int[]{1,2,3,4});
        //int i = minNumberInRotateArray2333(new int[]{1,2,3,4});
        System.out.println(i);
    }
}
