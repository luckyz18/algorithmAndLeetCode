package a3_jianzhi_offer;

/**
 * 连续子数组的最大和
 */
public class code_42 {
    public static int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int greatestSum = Integer.MIN_VALUE;
        int curSum = 0;
        for (int i = 0; i < array.length; i++) {
            if (curSum < 0) {
                curSum = array[i];
            } else {
                curSum = curSum + array[i];
            }
            greatestSum = Math.max(greatestSum, curSum);
        }
        return greatestSum;
    }

    public static void main(String[] args) {
        int a = FindGreatestSumOfSubArray(new int[]{-2,-8,-1,-5,-9});
        System.out.println(a);
    }
}
