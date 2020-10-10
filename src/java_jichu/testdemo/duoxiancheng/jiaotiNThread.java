package java_jichu.testdemo.duoxiancheng;

import java.util.concurrent.Semaphore;

/**
 * N 个线程循环打印 0
 * 信号量
 * 等待前一个线程的信号量
 */
public class jiaotiNThread {

    static int result = 0;
    public static void main(String[] args) throws InterruptedException {
        int N = 3;
        Thread[] threads = new Thread[N];
        final Semaphore[] syncObjects = new Semaphore[N];
        for (int i = 0; i < N; i++) {
            syncObjects[i] = new Semaphore(1);
            if (i != N-1){
                // 0 线程等待 N-1信号量，让0线程第一个执行
                syncObjects[i].acquire();  // -1 => 0
            }
        }
        for (int i = 0; i < N; i++) {
            final Semaphore lastSemphore = i == 0 ? syncObjects[N - 1] : syncObjects[i - 1];
            final Semaphore curSemphore = syncObjects[i];
            final int index = i;
            threads[i] = new Thread(new Runnable() {

                public void run() {
                    try {
                        while (true) {
                            lastSemphore.acquire();
                            System.out.println("thread" + index + ": " + result++);
                            if (result > 100){
                                System.exit(0);
                            }
                            curSemphore.release();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            });
            threads[i].start();
        }
    }

}
