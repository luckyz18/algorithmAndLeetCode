package jianzhi_offer;

/**
 * 翻转字符串
 * Input:
 * "I am a student."
 *
 * Output:
 * "student. a am I"
 */
public class code_58 {

    public String ReverseSentence(String str) {
        if (str == null || str.length() == 0){
            return str;
        }
        //条件是 不可以使用额外的空间 在字符数组上进行操作
        int len = str.length();
        char[] chars = str.toCharArray();
        reverse(chars,0,len-1);
        //翻转每个单词
        int i = 0;
        int j = 0;
        while (j <= len){
            if (j == len  || chars[j] == ' '){
                reverse(chars,i,j-1);
                i = j+1;
            }
            j++;
        }
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
        String s = new code_58().ReverseSentence("I am a student.    ");
        System.out.println(s);
    }
}
