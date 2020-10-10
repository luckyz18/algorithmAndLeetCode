package java_jichu.testdemo;

import java.time.LocalDateTime;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 信号量
 */
public class SemaphoreDemo {
    public static void  fun1(){
        Semaphore semaphore = new Semaphore(2);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 0,
                TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        for (int i = 0; i <5 ; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        //获取许可
                        semaphore.acquire();
                        System.out.println(Thread.currentThread().getName() + "时间：" + LocalDateTime.now());
                        TimeUnit.SECONDS.sleep(2);
                        //释放许可
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }


    public static void main(String[] args) {
        fun1();
    }
}
