package a3_jianzhi_offer;

import java.util.Arrays;

/**
 * 扑克牌中的顺子
 */
public class code_61 {
    public static boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return false;
        }
        Arrays.sort(numbers);
        //统计0的个数
        int countZero = 0;
        int countGap = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                countZero++;
            }
        }
        for (int i = countZero; i < numbers.length-1; i++) {
            if ( numbers[i] == numbers[i+1]){
                return false;
            }
            if (numbers[i+1] - numbers[i] > 1) {
                countZero -= numbers[i+1] - numbers[i] - 1;
            }
        }

        return countZero >= 0 ? true : false;
    }

    public static void main(String[] args) {
        boolean continuous = isContinuous(new int[]{1,3,0,5,0});
        System.out.println(continuous);
    }
}
