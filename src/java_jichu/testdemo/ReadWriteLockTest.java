package java_jichu.testdemo;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 共享锁例子
 */
public class ReadWriteLockTest {

    public static void main(String[] args) throws InterruptedException {
        final MyReadWriteLock rwLock = new MyReadWriteLock();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                rwLock.read();
            }
        }, "r1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                rwLock.read();
            }
        }, "r2");
        t1.start();
        t2.start();
        //
        t1.join();
        t2.join();
        //开启写
        new Thread(new Runnable() {
            @Override
            public void run() {
                rwLock.write();
            }
        }, "w1").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                rwLock.write();
            }
        }, "w2").start();
    }

    static class MyReadWriteLock {

        ReadWriteLock lock = new ReentrantReadWriteLock();

        public void read() {
            try {
                lock.readLock().lock();
                System.out.println("读操作，进入 | 线程：" +
                        Thread.currentThread().getName());
                Thread.sleep(3000);
                System.out.println("读操作，退出 | 线程：" +
                        Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.readLock().unlock();
            }
        }

        public void write() {
            try {
                lock.writeLock().lock();
                System.out.println("写操作，进入 | 线程：" +
                        Thread.currentThread().getName());
                Thread.sleep(3000);
                System.out.println("写操作，退出 | 线程：" +
                        Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.writeLock().unlock();
            }
        }
    }
}
