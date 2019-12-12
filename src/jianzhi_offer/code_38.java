package jianzhi_offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 字符串全排列
 */
public class code_38 {

    public static ArrayList<String> Permutation2(String str) {
        if (str.length() == 0) {
            return new ArrayList<>();
        }
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        ArrayList<String> list = new ArrayList<>();
        int len = chars.length;
        boolean[] isUsed = new boolean[len];
        backTrack4Permute(chars, len, list, new StringBuffer(),isUsed);
        return list;
    }

    private static void backTrack4Permute(char[] chars, int len, ArrayList<String> list, StringBuffer temString, boolean[] isUsed) {
        if (temString.toString().length() == len) {
            list.add(temString.toString());
        } else {
            //每次向后找一个可用的元素
            for (int i = 0; i < len; i++) {
                if ( isUsed[i] || (i > 0 && chars[i] == chars[i-1] && !isUsed[i-1]) ){
                    continue;
                }
                isUsed[i] = true;
                temString.append(chars[i]);
                backTrack4Permute(chars,len,list,temString,isUsed);
                isUsed[i] = false;
                temString.deleteCharAt(temString.length()-1);
            }
        }
    }

    //-------------------------------------------------
    public static ArrayList<String> Permutation3(String str) {
        char[] chs = str.toCharArray();
        ArrayList<String> list = new ArrayList<>();
        process2(chs, 0,list);
        return list;
    }
    public static void process2(char[] chs, int i,List<String> list) {
        if (i == chs.length) {
           list.add(String.valueOf(chs));
        }
        HashSet<Character> set = new HashSet<>();
        for (int j = i; j < chs.length; j++) {
            if (!set.contains(chs[j])) {
                set.add(chs[j]);
                swap(chs, i, j);
                process2(chs, i + 1,list);
                swap(chs, i, j);
            }
        }
    }
    public static void swap(char[] chs, int i, int j) {
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }

    //----------------------------------------------


    public static void main(String[] args) {
        ArrayList<String> list = Permutation3("acc");
        System.out.println();
    }
}
