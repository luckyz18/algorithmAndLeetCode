package jianzhi_offer;

/**
 * 替换空格
 *  类似的还有合并排序数组
 *  思路：从后往前复制
 */
public class code_05 {
    public static String replaceSpace(StringBuffer str) {
        if (str == null || "".equals(str)) {
            return null;
        }
        int p = str.length() - 1;
        for (int i = 0; i <= p; i++) {
            if (str.charAt(i) == ' ') {
                str.append("  ");  //两个空格
            }
        }
        int q = str.length() - 1;
        while (p >= 0 && q > p) {
            char c = str.charAt(p--);
            if (c == ' ') {
                str.setCharAt(q--, '0');
                str.setCharAt(q--, '2');
                str.setCharAt(q--, '%');
            } else {
                str.setCharAt(q--, c);
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        String s = replaceSpace(new StringBuffer("    "));
        System.out.println(s);
    }
}
