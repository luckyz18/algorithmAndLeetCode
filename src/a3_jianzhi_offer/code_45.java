package a3_jianzhi_offer;

import java.util.Arrays;

/**
 * 把数组排成最小的数
 */
public class code_45 {

    public static String PrintMinNumber(int [] numbers) {
        if (numbers == null || numbers.length ==0){
            return "";
        }
        String[] num = new String[numbers.length];
        for (int i = 0; i <numbers.length ; i++) {
            num[i] = numbers[i]+"";
        }
        Arrays.sort(num, (o1, o2) -> (o1+o2).compareTo(o2+o1));
        String res = "";
        for ( String s : num) {
            res += s;
        }
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        PrintMinNumber(new int[] {3,32,321});
    }
}
