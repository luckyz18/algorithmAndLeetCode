package testdemo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDownLatchExample {

    public void fun1() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(5);
        Service service = new Service(latch);
        Runnable task = () -> service.exec();

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(task);
            thread.start();
        }
        System.out.println("main thread await. ");
        latch.await();
        System.out.println("main thread finishes await. ");
    }

    //模拟医生患者同步
    public static void fun2() throws InterruptedException {
        CountDownLatch hospital = new CountDownLatch(1);
        CountDownLatch patient = new CountDownLatch(10);
        System.out.println("患者排队");
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        hospital.await();    //等着医生来
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("就诊 " + finalI);
                    patient.countDown();
                }
            });
        }
        System.out.println("医生上班");
        hospital.countDown();
        patient.await();      //主线程等待各个线程执行完
        System.out.println("下班");
        executorService.shutdown();
    }

    public static void main(String[] args) throws InterruptedException {
        fun2();
    }
}

class Service {
    private CountDownLatch latch;

    public Service(CountDownLatch latch) {
        this.latch = latch;
    }

    public void exec() {
        try {
            System.out.println(Thread.currentThread().getName() + " execute task. ");
            sleep(2);
            System.out.println(Thread.currentThread().getName() + " finished task. ");
        } finally {
            latch.countDown();
        }
    }

    private void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
