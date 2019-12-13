package jianzhi_offer;

import java.util.HashMap;
import java.util.Map;

public class code_50 {
    public int  firstNotRepeatingChar(String str){
        if (str == null || str.length() ==0){
            return -1;
        }
        Map<Character,Integer> map = new HashMap();
        for (int i = 0; i <str.length() ; i++) {
            char key = str.charAt(i);
            if (map.containsKey(key)){
                map.put(key, map.get(key)+1);
            }else{
                map.put(key,1);
            }
        }

        for (int i = 0; i <str.length() ; i++) {
            char key = str.charAt(i);
            if (map.get(key) == 1){
                return i;
            }
        }
        return -1;
    }

    //
    public static int  firstNotRepeatingChar2(String str){
        if (str == null || str.length() ==0){
            return -1;
        }
        //一个字符占8位 一共有256种字符的种类
        int[] help = new int[256];
        int len = str.length();
        for (int i = 0; i <len ; i++) {
            help[str.charAt(i)]++;
        }
        for (int i = 0; i <len ; i++) {
            if (help[str.charAt(i)] == 1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        firstNotRepeatingChar2("abacc");
        System.out.println();
    }

}
