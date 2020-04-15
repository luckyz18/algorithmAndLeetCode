package mianshi.ali;

public class test {
    public static void main(String[] args) {
        String c = new String("abc");
        String a = "abc";
        String b = "abc";


        System.out.println(a == c);
        System.out.println(System.identityHashCode(a));
        System.out.println(System.identityHashCode(b));

    }
}
