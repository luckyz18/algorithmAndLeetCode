package testdemo;

public class CloneDemo {
    int num = 0;

    class A implements Cloneable {
        String name = "aaa";

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        A a = new CloneDemo().new A();
        A clone = (A) a.clone();

    }

}
