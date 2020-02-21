package java_jichu;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemphoreExample {
    private static final int THREAD_COUNT = 30;

    private static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);

    private static Semaphore s = new Semaphore(10);

    //public static void main(String[] args) {
    //    for (int i = 0; i < THREAD_COUNT; i++) {
    //        threadPool.execute(new Employee(String.valueOf(i), s));
    //    }
    //
    //    threadPool.shutdown();
    //}

    static class Employee implements Runnable {
        private String id;
        private Semaphore semaphore;
        private static Random rand = new Random(47);

        public Employee(String id, Semaphore semaphore) {
            this.id = id;
            this.semaphore = semaphore;
        }

        public void run() {
            try {
                semaphore.acquire();
                System.out.println(this.id + "is using the toilet");
                TimeUnit.MILLISECONDS.sleep(rand.nextInt(2000));
                semaphore.release();
                System.out.println(this.id + "is leaving");
            } catch (InterruptedException e) {
            }
        }
    }

    //
    public static void main(String[] args) {
        final int clientCount = 3;
        final int totalRequestCount = 10;
        Semaphore semaphore = new Semaphore(clientCount);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < totalRequestCount; i++) {
            int tmp = i;
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    System.out.println(tmp + " is using ");
                    System.out.println("剩余的 ： " + semaphore.availablePermits() +"====");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                    System.out.println(tmp +  " 离开。。。 ");
                }
            });
        }
        executorService.shutdown();
    }


}

