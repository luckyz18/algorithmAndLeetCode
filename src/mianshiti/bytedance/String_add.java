package mianshiti.bytedance;

/**
 * 字符串相加   整数
 */
public class String_add {

    public static String add(String num1,String num2){
        if (num1 == null ||num2 == null){
            return num1 == null? num2 : num1;
        }
        int len1= num1.length()-1;
        int len2 = num2.length()-1;
        int flag = 0;
        StringBuilder sb = new StringBuilder();
        while (len1>= 0 || len2 >= 0 || flag != 0){
            int x = len1 >= 0 ? num1.charAt(len1)-'0' : 0;
            int y = len2 >= 0 ? num2.charAt(len2)-'0' : 0;
            int sum = x + y + flag;
            flag = sum / 10;
            sb.append(sum % 10);
            len1--;
            len2--;
        }
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        String add = add("12", "34");
        System.out.println(add);
    }
}
