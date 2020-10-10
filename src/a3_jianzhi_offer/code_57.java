package a3_jianzhi_offer;

import java.util.ArrayList;

//和为 S 的两个数字
public class code_57 {
    public static ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        if (array == null || array.length == 0){
            return new ArrayList<>();
        }
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        int j = array.length-1;
        while (i<= j){
            if (array[i] + array[j] < sum){
                i++;
            }else if(array[i] + array[j] == sum){
                list.add(array[i]);
                list.add(array[j]);
                break;
            }else{
                j--;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = FindNumbersWithSum(new int[]{1, 2, 3, 5, 6, 8, 12}, 14);
        for ( Integer tmp: list) {
            System.out.println(tmp);
        }
    }
}
