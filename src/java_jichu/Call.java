package java_jichu;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Call implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("555555");
        return 22;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Call instance = new Call();
        FutureTask<Integer> ft = new FutureTask<>(instance);
        Thread thread = new Thread(ft);
        thread.start();
        System.out.println(ft.get());

    }
}
