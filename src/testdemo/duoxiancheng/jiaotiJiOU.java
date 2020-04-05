package testdemo.duoxiancheng;

/**
 * 多线程交替打印
 * 奇偶数 交替打印 两个线程
 */
public class jiaotiJiOU {
    static class SoulutionTask implements Runnable{
        static int value = 0;
        @Override
        public void run() {
            while (value <= 20){
                synchronized (SoulutionTask.class){
                    System.out.println(Thread.currentThread().getName() + ":" + value++);
                    SoulutionTask.class.notify();
                    try {
                        SoulutionTask.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        public static void main(String[] args) throws InterruptedException {
            new Thread(new SoulutionTask(), "偶数").start();
            Thread.sleep(1000); //控制
            new Thread(new SoulutionTask(), "奇数").start();
        }
        //有一个问题 第一个打印的可能是奇/偶
    }
}
