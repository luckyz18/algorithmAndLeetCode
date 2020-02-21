package java_jichu;

public class InterfaceImplementExample implements InterfaceExample{
    static int b = 2;
    int c = 3;
    final int d = 4;
    //a = 111;

    @Override
    public void fun1() {
        System.out.println("我是fun1");
    }

     void  test(){
        System.out.println(a);
        System.out.println(fun3());
    }

    public static void main(String[] args) {
        InterfaceImplementExample A = new InterfaceImplementExample();
        A.test();

    }

}
