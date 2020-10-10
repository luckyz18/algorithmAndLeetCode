package a3_jianzhi_offer;

/**
 * 数组中的逆序对
 */
public class code_51 {
    private long sum = 0;  //这里改成了long 通过了  别用int
    public int InversePairs(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        mergeSort(array, 0, array.length - 1);
        return (int)(sum % 1000000007);
    }

    private void  mergeSort(int[] array, int l, int r) {
        if ( l == r){
            return;
        }
        int mid = (l + r) / 2;
        mergeSort(array, l, mid);
        mergeSort(array, mid + 1, r);
        merge(array, l, mid, r);
    }

    private void merge(int[] array, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int index = 0;
        int p = l;
        int q = mid+1;
        while (p <= mid && q <= r) {
            if (array[p] > array[q]) {
                //逆序对出现
                sum += (mid - p + 1);
                help[index++] = array[q++];
            }else {
                help[index++] = array[p++];
            }
        }
        while (p <= mid) {
            help[index++] = array[p++];
        }
        while (q <= r) {
            help[index++] = array[q++];
        }
        for (int i = 0; i <help.length ; i++) {
            array[l+i] = help[i];
        }
    }

    public static void main(String[] args) {
        int i = new code_51().InversePairs(new int[]{1});
        System.out.println(i);
    }
}
