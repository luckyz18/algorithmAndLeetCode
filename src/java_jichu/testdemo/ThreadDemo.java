package java_jichu.testdemo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();

        MyRunnable myRunnable = new MyRunnable();
        new Thread(myRunnable).start();

        MyCallable myCallable = new MyCallable();
         /*定义返回结果*/
        FutureTask<String> result = new FutureTask(myCallable);
        /*执行程序*/
        new Thread(result).start();
        /*输出返回结果*/
        System.out.println(result.get());

        //join
        /*Thread thread = new Thread(()->{
            System.out.println("执行前");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("执行后");
        });
        thread.start();
        thread.join();
        System.out.println("hahahha");*/

        //两个线程依次打印1 1 2 2 3 3 4 4
        /*new Thread(() -> {
            for (int i = 1; i < 5; i++) {
                System.out.println("线程1：" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 1; i < 5; i++) {
                System.out.println("线程2：" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();*/

    }
}

//线程创建的三种方式
//1. 继承thread 类
class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("thread...");
    }
}

//实现 runnable接口
class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("runnable...");
    }
}

//实现callable
class MyCallable implements Callable {
    @Override
    public String call() throws Exception {
        System.out.println("call...");
        return "success";
    }
}
