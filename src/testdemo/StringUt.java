package testdemo;

public class StringUt implements Cloneable {
    private int num;
    public static void main(String[] args) throws CloneNotSupportedException {
        String[] s = new String[] {"a","b","c"};
        /*String str = StringUtils.join(Arrays.asList(s), ",");
        System.out.println(str);

        String s1 = Arrays.toString(s);
        System.out.println(s1);*/

        //Arrays.asList(s).forEach(x-> System.out.println(x));
        StringUt a = new StringUt();
        a.num = 1;
        StringUt b = (StringUt) a.clone();
        System.out.println(b.num);


    }
}
