package java_jichu.testdemo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalTest {
    public static void fun() {
        ThreadLocal<List> threadLocal = new ThreadLocal<>();
        threadLocal.set(Arrays.asList("哈哈", "hehe"));
        List o = threadLocal.get();
        System.out.println(o.size());
        System.out.println(threadLocal.get());
        threadLocal.remove();
        System.out.println(threadLocal.get());
    }

    public static void fun2() {
        InheritableThreadLocal<Object> inheritableThreadLocal = new InheritableThreadLocal<>();
        inheritableThreadLocal.set("旺旺");
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(inheritableThreadLocal.get());
            }
        }).start();
    }

    //
    private static ThreadLocal threadLocal = new ThreadLocal();
    private static Integer MOCK_MAX = 10000;
    private static Integer THREAD_MAX = 100;

    public static void main(String[] args) throws  InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_MAX);
        for (int i = 0; i < THREAD_MAX; i++) {
            executorService.execute(() -> {
                threadLocal.set(new  ThreadLocalTest().getList());
                System.out.println(Thread.currentThread().getName());
                // 移除对象
                // 这样就不会内存泄漏了
                threadLocal.remove();
            });
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();
    }

    List getList() {
        List list = new ArrayList();
        for (int i = 0; i < MOCK_MAX; i++) {
            list.add("Version：JDK 8");
            list.add("ThreadLocal");
            list.add("Author：老王");
            list.add("DateTime：" + LocalDateTime.now());
            list.add("Test：ThreadLocal OOM");
        }
        return list;
    }


}
