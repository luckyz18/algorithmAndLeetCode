package testdemo;

/**
 * 局部内部类
 */
public class OuterLocal {

    public void sayHi() {
        //局部内部类不能使用修饰符
        // 可以直接使用方法内部的变量
        class InnerClass {
            InnerClass(String name) {
                System.out.println("InnerClass:" + name);
            }
        }
        System.out.println(new InnerClass("Three"));
        System.out.println("Hi, OutClass");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(){
            @Override
            public void run() {
                System.out.println("aaa");
            }
        };
        //thread.start();

        //
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

            }
        };
    }

}

class OutTest {
    public static void main(String[] args) {
        new OuterLocal().sayHi();
    }
}
