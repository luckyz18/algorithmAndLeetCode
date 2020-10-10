package java_jichu.testdemo;

public class Outer {
    private String name = "outerClass";
    public void hello(){
        System.out.println("Hi~outer.");
        //外部类访问内部类
        System.out.println(new Inner().name);
    }
    public Outer() {
        System.out.println("Outer Class.");
    }
    public class Inner {
        String name = "Innername";
        public void sayHi() {
            System.out.println("Hi, Inner.");
            //内部类访问外部类
            Outer.this.hello();
            System.out.println(Outer.this.name);
        }
    }
    public static void main(String[] args) {
        new Outer().new Inner().sayHi();
    }
}
class InnerTest{
    public static void main(String[] args) {
        Outer outer = new Outer();
        //创建成员内部类
        Outer.Inner inner = outer.new Inner();
        inner.sayHi();
    }
}
