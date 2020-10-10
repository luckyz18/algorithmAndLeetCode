package java_jichu.testdemo;

public interface IAnimal {
    String name = "name";
    static void run(){
        System.out.println(" animal run ");
    }
    default void eat(){
        System.out.println("eat..");
    }

    static void hh() {

    }
}
