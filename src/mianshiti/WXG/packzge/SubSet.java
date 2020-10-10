package mianshiti.WXG.packzge;

import java.util.ArrayList;

/**
 * 集合的所有子集  枚举子集
 */
public class SubSet {
    public static ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if(S == null || S.length == 0){
            return list;
        }
        subsets(S,0,list, new ArrayList<>());
        return list;
    }

    private static void subsets(int[] s, int start, ArrayList<ArrayList<Integer>> ret, ArrayList<Integer> temp) {
        ret.add(new ArrayList<>(temp));
        for (int i = start; i < s.length ; i++) {
            temp.add(s[i]);
            subsets(s,i+1, ret, temp);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {
        subsets(new int[] {1,2,3});
        System.out.println();
    }
}
