package java_jichu.testdemo;

/**
 * 死锁的例子
 */
public class SiSuo {
    public static void main(String[] args) {
        Object obj1 = new Object();
        Object obj2 = new Object();
        // 线程1拥有对象1，想要等待获取对象2
        new Thread() {
            @Override
            public void run() {
                synchronized (obj1) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (obj2) {
                        //Thread thread = Thread.currentThread();
                        System.out.println(Thread.currentThread().getName());
                    }
                }
            }
        }.start();
        // 线程2拥有对象2，想要等待获取对象1
        new Thread() {
            @Override
            public void run() {
                synchronized (obj2) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (obj1) {
                        System.out.println(Thread.currentThread().getName());
                    }
                }
            }
        }.start();
    }


}
