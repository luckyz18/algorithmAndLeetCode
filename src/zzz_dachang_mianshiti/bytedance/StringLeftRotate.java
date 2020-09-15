package zzz_dachang_mianshiti.bytedance;

/**
 * 字符串循环左移
 *
 */
public class StringLeftRotate {

    //1. 字符串截取
    public static String  leftRotate(String s, int k){
        if (s == null || s.length() == 0 || s.trim().length() == 0){
            return null;
        }
        k = k % s.length();
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(k,s.length()));
        sb.append(s.substring(0,k));
        return sb.toString();
    }

    // 2. 第二种思路  部分翻转  洗牌算法
    // abcdefg   k =3, 先把abcd翻转；edf翻转； 再整体翻转


    public static void main(String[] args) {
        String outS = leftRotate(new String("  "), 8);
        System.out.println(outS);
    }
}
