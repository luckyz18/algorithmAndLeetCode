package java_jichu.testdemo;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程池
 */
public class ThreadPoolExecutorTest {
    public static void fun1() {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2,
                2, 10L, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                new MyThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());
        threadPool.allowCoreThreadTimeOut(true);
        for (int i = 0; i < 10; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public static void func2() {
        //创建线程池
        ThreadPoolExecutor threadPool2 = new ThreadPoolExecutor(2, 10, 10L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(100));

        Future<String> result = threadPool2.submit(new Callable<String>() {
            @Override
            public String call() {
                System.out.println("Hello java");
                return "success";
            }
        });
        System.out.println("hhehehehe");
        //System.out.println(result.get());
        System.out.println("hahahah");
    }

    // innterrupt
    public static void fun3() {
        ThreadPoolExecutor threadPoolExecutor = new
                ThreadPoolExecutor(2, 10, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 2; i++) {
                    System.out.println("I：" + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        threadPoolExecutor.shutdown();
        //threadPoolExecutor.execute(new Runnable() {
        //    @Override
        //    public void run() {
        //        System.out.println("dilidili..");
        //    }
        //});
        System.out.println("java ...");
    }

    //打印
    public static void fun4(){
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,
                5, 10L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                new ThreadPoolExecutor.DiscardPolicy());
        threadPoolExecutor.allowCoreThreadTimeOut(true);

        threadPoolExecutor.execute(new Runnable() {   //这里面是一个线程执行的
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("I：" + i + "---" + Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public static void fun5(){
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,
                2, 10L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(10),
                new ThreadPoolExecutor.DiscardPolicy());
        threadPoolExecutor.allowCoreThreadTimeOut(true);

        for (int i = 0; i <10 ; i++) {  //想创建了 10个线程去执行，但是只创建了3个，加上bq, 执行了5个任务
            int c = i;
            //每执行一个execute，理解成创建了一个执行一个任务，如果max线程数+队列 > 总个数，就能执行完
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(c + " " +Thread.currentThread().getName());
                    //try {
                    //    //Thread.sleep(1000);
                    //} catch (InterruptedException e) {
                    //    e.printStackTrace();
                    //}
                }
            });
        }
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        fun5();
    }
}

class MyThreadFactory implements ThreadFactory {
    private AtomicInteger count = new AtomicInteger(0);

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        String threadName = "mythread  " + count.addAndGet(1);
        thread.setName(threadName);
        return thread;
    }
}
