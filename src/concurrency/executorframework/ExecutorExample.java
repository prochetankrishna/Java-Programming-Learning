package concurrency.executorframework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class PrintRunnable implements Runnable {

    String taskName;

    public PrintRunnable (String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        System.out.println(this.taskName + " started by Thread: " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        System.out.println(this.taskName + " completed by Thread: " + Thread.currentThread().getName());
    }
}

public class ExecutorExample {

    public static void main(String[] args) {

        PrintRunnable[] printTask = {
                new PrintRunnable("Print Logs Task"),
                new PrintRunnable("Get DB Connection Task"),
                new PrintRunnable("Save Operation Task"),
                new PrintRunnable("Close DB Connection Task")
        };

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (PrintRunnable eachTask : printTask) {
            executorService.submit(eachTask);
        }
        executorService.shutdown();
    }
}
