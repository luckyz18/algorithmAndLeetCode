package java_jichu.testdemo;

public class OuterDemoStatic {
    String name = "aaa";
    public OuterDemoStatic() {
        System.out.println("outer init .");
    }
    public static class InnerC {
        public void say(){
            System.out.println("inner hi ");
            //不能从静态成员内部类中访问非静态外部类对象。
            //System.out.println(new OuterDemoStatic().name);  //可以
            //System.out.println(OuterDemoStatic.this.name); //错误的
        }
    }
    public static void main(String[] args) {
        InnerC innerC = new InnerC();
        //OuterDemoStatic.InnerC i  = new    OuterDemoStatic.InnerC();
        innerC.say();
    }
}
class InnerTest2{
    public static void main(String[] args) {
        //创建static成员内部类
        OuterDemoStatic.InnerC innerC = new OuterDemoStatic.InnerC();
        OuterDemoStatic outer = new OuterDemoStatic();
    }
}
