package jianzhi_offer;

import java.util.ArrayList;

//和为 S 的连续正数序列
public class code_57_2 {
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        if (sum <= 0) {
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int end = (sum + 1) / 2;
        int i = 1;
        int j = i + 1;
        int curSum = i + j;
        ArrayList<Integer> tmp = new ArrayList();
        tmp.add(i);
        tmp.add(j);
        while (j <= end) {
            if (curSum == sum) {
                list.add(new ArrayList<>(tmp));
                curSum -= i;
                i++;
                tmp.remove(0);
            } else if (curSum < sum) {
                j++;
                tmp.add(j);
                curSum += j;
            } else {
                curSum -= i;
                tmp.remove(0);
                i++;
            }
        }
        return list;
    }
    //2. 思路一样
    public ArrayList<ArrayList<Integer>> FindContinuousSequence2(int sum) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        int start = 1, end = 2;
        int curSum = 3;
        while (end < sum) {
            if (curSum > sum) {
                curSum -= start;
                start++;
            } else if (curSum < sum) {
                end++;
                curSum += end;
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = start; i <= end; i++)
                    list.add(i);
                ret.add(list);
                curSum -= start;
                start++;
                end++;
                curSum += end;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> a = FindContinuousSequence(1);
        System.out.println();
    }
}
