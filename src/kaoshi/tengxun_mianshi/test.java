package kaoshi.tengxun_mianshi;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int[] a= new int[] {1,2,3,4};
        int[] b = Arrays.copyOf(a,a.length);
        b[1] = 10;
        System.out.println();
        //深拷贝。。。
    }
}
