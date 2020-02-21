package java_jichu;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExample {

    private AtomicInteger cnt = new AtomicInteger();
    public void add(){
        cnt.incrementAndGet();
    }
    public int get(){
        return cnt.get();
    }

    public static void main(String[] args) throws InterruptedException {
        int threadSize = 1000;
        AtomicExample example = new AtomicExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(threadSize);
        for (int i = 0; i <threadSize ; i++) {
            executorService.execute(()->{
                example.add();
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println(example.get());
    }
}
