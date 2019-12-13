package jianzhi_offer;

import java.util.Arrays;

/**
 * 字符流中第一个只出现一次的字符
 */
public class code_50_2 {
    private static int[] help = new int[256];
    private static int index = 0;
    static {
        Arrays.fill(help,-1);
    }

    public static void Insert(char ch) {
        //没出现
       if (help[ch] == -1){
           help[ch] = index;
           index++;
       }else if (help[ch] >= 0){
           //出现多次
           help[ch]= -2;
           index++;
       }
    }

    public static char FirstAppearingOnce() {
        int minIndex = Integer.MAX_VALUE;
        char ch = '#';
        for (int i = 0; i < 256; i++) {
            if (help[i] >= 0 && minIndex > help[i] ){
                //出现一次
                minIndex = help[i];
                ch = (char) i;
            }
        }
        return ch;
    }

    public static void main(String[] args) {
        Insert('g');
        System.out.println( FirstAppearingOnce() +"-------------------");
        Insert('o');
        System.out.println( FirstAppearingOnce() +"-------------------");
        Insert('o');
        System.out.println( FirstAppearingOnce() +"-------------------");
        Insert('g');
        System.out.println( FirstAppearingOnce() +"-------------------");
        Insert('l');
        System.out.println( FirstAppearingOnce() +"-------------------");
        Insert('e');
        System.out.println( FirstAppearingOnce() +"-------------------");

    }
}
