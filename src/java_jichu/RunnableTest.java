package java_jichu;

public class RunnableTest implements Runnable {
    int i = 0;

    @Override
    public void run() {
        i++;
        System.out.println("run1111111====" + i);
    }

    public static void main(String[] args) {
        RunnableTest runnableTest = new RunnableTest();
        Thread thread = new Thread(runnableTest);
        Thread thread2 = new Thread(runnableTest);
        thread.start();
        thread2.start();
    }
}
