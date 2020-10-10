package a3_jianzhi_offer;

import java.util.Arrays;

/**
 * 最长不含重复字符的子字符串
 */
public class code_48 {
    public static int longestSubStringWithNoDuplicate(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int len = str.length();
        int[] position = new int[26];
        Arrays.fill(position, -1);
        int maxLen = 0;
        //数组 f[] 存放以i结尾的最长子字符串
        int[] f = new int[len];
        f[0] = 1;
        position[str.charAt(0) - 'a'] = 0;
        for (int i = 1; i < len; i++) {
            if (position[str.charAt(i) - 'a'] == -1) {
                position[str.charAt(i) - 'a'] = i;
                f[i] = f[i - 1] + 1;
            } else {
                int d = i - position[str.charAt(i) - 'a'];
                if (d > f[i - 1]) {
                    f[i] = f[i - 1] + 1;
                } else {
                    f[i] = d;

                }
                position[str.charAt(i) - 'a'] = i;
            }
            maxLen = Math.max(maxLen, f[i]);
        }
        return maxLen;
    }

    //
    public static int longestSubStringWithoutDuplication2(String str) {
        int curLen = 0;
        int maxLen = 0;
        int[] preIndexs = new int[26];
        Arrays.fill(preIndexs, -1);
        for (int curI = 0; curI < str.length(); curI++) {
            int c = str.charAt(curI) - 'a';
            int preI = preIndexs[c];
            if (preI == -1 || curI - preI > curLen) {
                curLen++;
            } else {
                maxLen = Math.max(maxLen, curLen);
                curLen = curI - preI;
            }
            preIndexs[c] = curI;
        }
        maxLen = Math.max(maxLen, curLen);
        return maxLen;
    }

    public static void main(String[] args) {
        int g = longestSubStringWithoutDuplication2("");
        System.out.println(g);
    }

}
