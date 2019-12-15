package jianzhi_offer;

/**
 * 左旋转字符串
 */
public class code_58_2 {
    public String LeftRotateString(String str, int n) {
        if (str == null || str.length() == 0 || n <= 0 || n > str.length()) {
            return str;
        }
        int len = str.length();
        char[] chars = str.toCharArray();
        reverse(chars, 0, n - 1);
        reverse(chars, n, len - 1);
        reverse(chars, 0, len - 1);
        return new String(chars);
    }

    private void reverse(char[] chars, int i, int j) {
        while (i < j) {
            swap(chars, i, j);
            i++;
            j--;
        }
    }

    private void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

    public static void main(String[] args) {
        String s = new code_58_2().LeftRotateString("abcdef", 7);
        System.out.println(s);
    }

}
