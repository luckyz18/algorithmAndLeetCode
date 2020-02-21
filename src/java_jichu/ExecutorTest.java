package java_jichu;

import java.sql.SQLOutput;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ExecutorTest {

    //public static void main(String[] args) {
    //    ExecutorService executorService = Executors.newCachedThreadPool();
    //    executorService.execute(()->{
    //        try {
    //            System.out.println("mimimimi-----");
    //            Thread.sleep(2000);
    //            System.out.println("Thread run");
    //        } catch (InterruptedException e) {
    //            e.printStackTrace();
    //        }
    //    });
    //    executorService.shutdown();
    //    System.out.println("main run ... ");
    //    System.out.println("aaaaa");
    //}

    public void func2() {
        synchronized (ExecutorTest.class) {
            for (int i = 0; i < 10; i++) {
                System.out.print(i + " ");
                System.out.println(Thread.currentThread().getName() + "------");
            }
        }
    }

    // 对整个类进行同步  不同对象间也进行同步
    private Lock lock = new ReentrantLock();
    public void func1() {
        lock.lock();
        try {
            for (int i = 0; i < 10; i++) {
                System.out.print(i + " ");
                System.out.println(Thread.currentThread().getName()+"------");
            }
        } finally {
            lock.unlock(); // 确保释放锁，从而避免发生死锁。
        }
    }

    public synchronized void before(){
        System.out.println("before");
        notify();
    }
    public synchronized void after(){
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("after");
    }

    public synchronized void after2(){
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("after2222");
    }


    public static void main(String[] args) {
        //ExecutorTest lockExample = new ExecutorTest();
        //ExecutorTest lockExample2 = new ExecutorTest();
        //ExecutorService executorService = Executors.newCachedThreadPool();
        //executorService.execute(() -> lockExample.func1());
        //executorService.execute(() -> lockExample2.func1());

        ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorTest example = new ExecutorTest();
        executorService.execute(() -> example.after());
        executorService.execute(() -> example.after2());
        executorService.execute(() -> example.before());
    }

}
