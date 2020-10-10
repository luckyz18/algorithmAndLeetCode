package java_jichu.testdemo;

import java.util.Random;
import java.util.concurrent.Phaser;

public class PhaseDemo {
    public static void main(String[] args) {
        MyPhaser myPhaser = new MyPhaser();
        PhaserWorker[] phaserWorker = new PhaserWorker[5];
        for (int i = 0; i < phaserWorker.length; i++) {
            //phaserWorker[i] = new PhaserWorker(myPhaser);
            //注册 Phaser 等待的线程数，执行一次等待线程数 +1
            myPhaser.register();
        }
        for (int i = 0; i < phaserWorker.length; i++) {
            // 执行任务
            new Thread(new PhaserWorker(myPhaser)).start();
        }
    }
}

class PhaserWorker implements Runnable {
    private final Phaser phaser;
    public PhaserWorker(Phaser phaser) {
        this.phaser = phaser;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " |到达");
        phaser.arriveAndAwaitAdvance(); // 集合完毕发车
        try {
            Thread.sleep(new Random().nextInt(5) * 1000);
            System.out.println(Thread.currentThread().getName() + " |到达");
            phaser.arriveAndAwaitAdvance(); // 景点 1 集 合完毕发车
            Thread.sleep(new Random().nextInt(5) * 1000);
            System.out.println(Thread.currentThread().getName() + " |到达");
            phaser.arriveAndAwaitAdvance(); // 景点 2 集 合完毕发车
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// Phaser 每个阶段完成之后的事件通知
class MyPhaser extends Phaser {
    @Override
    protected boolean onAdvance(int phase, int
            registeredParties) { // 每个阶段执行完之后的回调
        switch (phase) {
            case 0:
                System.out.println("==== 集合完毕发车== == ");
                return false;
            case 1:
                System.out.println("==== 景点1集合完毕， 发车去下一个景点 ====");
                return false;
            case 2:
                System.out.println("==== 景点2集合完毕， 发车回家 ====");
                return false;
            default:
                return true;
        }
    }
}

