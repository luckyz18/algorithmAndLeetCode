package testdemo.thread_comn;

/**
 * 编写两个线程，一个线程打印1~25，另一个线程打印字母A~Z，打印顺序为12A34B56C……5152Z，要求使用线程间的通信。”
 * 解法一
 *  包含多种小的不同实现方式，但一个共同点就是靠一个共享变量来做控制；
 *      a. 利用最基本的synchronized、notify、wait：
 *      b. 利用Lock和Condition：condition.await(),condition.signal
 *      c. 利用volatile .不用了上锁的操作 其余相同
 * 第二种解法
 *  是利用 CyclicBarrierAPI；
 *
 */
public class MethodOne {
    class ThreadToGo {
        int value = 1;
    }

    private final ThreadToGo threadToGo = new ThreadToGo();

    public Runnable newThreadOne() {
        final String[] inputArr = Helper.buildNoArr(52);
        return new Runnable() {
            private String[] arr = inputArr;
            public void run() {
                try {
                    for (int i = 0; i < arr.length; i = i + 2) {
                        synchronized (threadToGo) {
                            while (threadToGo.value == 2)
                                threadToGo.wait();
                            Helper.print(arr[i], arr[i + 1]);
                            threadToGo.value = 2;
                            threadToGo.notify();
                        }
                    }
                } catch (InterruptedException e) {
                    System.out.println("Oops...");
                }
            }
        };
    }

    public Runnable newThreadTwo() {
        final String[] inputArr = Helper.buildCharArr(26);
        return new Runnable() {
            private String[] arr = inputArr;
            public void run() {
                try {
                    for (int i = 0; i < arr.length; i++) {
                        synchronized (threadToGo) {
                            while (threadToGo.value == 1)
                                threadToGo.wait();
                            Helper.print(arr[i]);
                            threadToGo.value = 1;
                            threadToGo.notify();
                        }
                    }
                } catch (InterruptedException e) {
                    System.out.println("Oops...");
                }
            }
        };
    }

    public static void main(String[] args) {
        MethodOne one = new MethodOne();
        Helper.instance.run(one.newThreadOne());
        Helper.instance.run(one.newThreadTwo());
        Helper.instance.shutdown();

    }
}
