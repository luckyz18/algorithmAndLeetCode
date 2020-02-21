package java_jichu;

public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("666666");
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }
}
