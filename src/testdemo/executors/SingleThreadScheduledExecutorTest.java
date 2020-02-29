package testdemo.executors;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SingleThreadScheduledExecutorTest {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        for (int i = 0; i < 3; i++) {
            int finalI = i;
            scheduledExecutorService.schedule(new Runnable() {
                @Override
                public void run() {
                    System.out.println("pool: ");
                    System.out.println(Thread.currentThread().getName()
                            +"--" + finalI +" "
                            + LocalDateTime.now());
                }
            }, 1L, TimeUnit.SECONDS);
        }
        System.out.println((Thread.currentThread().getName() + "cur" + LocalDateTime.now()));
    }
}
