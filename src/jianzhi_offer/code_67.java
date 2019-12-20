package jianzhi_offer;

/**
 * 字符串转换成整数
 */
public class code_67 {
    public static int StrToInt(String str) {
        if (str == null || str.length() ==0 ){
            return 0;
        }
        long num = 0;
        boolean f = true;
        for (int i = 0; i < str.length(); i++) {
            if (i==0 && str.charAt(i) == '+'){
                continue;
            }
            if (i==0 && str.charAt(i) == '-'){
                f = false;
                continue;
            }
            if ( Character.isDigit(str.charAt(i)) ) {
                num = num * 10 + (str.charAt(i) - '0');
            } else {
                num = 0;
                break;
            }
        }
        num = f == false ? -num : num;
        if (num> Integer.MAX_VALUE || num < Integer.MIN_VALUE){
            return 0;
        }
        return (int) num;
    }

    //简洁
    private boolean isInvalid = false;
    public int StrToInt2(String str) {
        if (str == null || str.length() == 0 || (str.length() ==1 && (str.charAt(0) == '+' || str.charAt(0) == '-'))) {
            isInvalid = true;
            return 0;  //这里有一个问题  当输入是字符串 0  的时候输出也是0 怎么区分？- 全局变量
        }
        boolean isNegative = str.charAt(0) == '-';
        int ret = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i == 0 && (c == '+' || c == '-'))  /* 符号判定 */
                continue;
            if (c < '0' || c > '9') {                /* 非法输入 */
                isInvalid = true;
                return 0;
            }
            ret = ret * 10 + (c - '0');
        }
        return isNegative ? -ret : ret;
    }

    public static void main(String[] args) {
        long i = StrToInt("-");
        System.out.println(i);
    }
}
