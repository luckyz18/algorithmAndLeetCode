package jianzhi_offer;

/**
 * 表示数字的字符串
 */
public class num_20 {
    public static boolean isNumeric(char[] str) {
        if(str == null || str.length == 0){
            return false;
        }
        boolean isMatch = new String(str).matches("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");
        return isMatch;
    }

    public static void main(String[] args) {
        boolean numeric = isNumeric("1.2.3".toCharArray());
        System.out.println(numeric);
    }
}
