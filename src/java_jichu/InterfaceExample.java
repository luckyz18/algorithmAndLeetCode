package java_jichu;

public interface InterfaceExample {
    int a = 1;  //static final

    void fun1();

    //static void fun2() {
    //    System.out.println("我是func2");
    //}
    default String fun3() {
        return ("我是func3");
    }

}
