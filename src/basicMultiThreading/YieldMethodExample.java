package basicMultiThreading;

public class YieldMethodExample {

    public static void main(String[] args) {

        /**
         * Yield Method - Pauses current executing Thread to give chance to waiting threads of same priority
         * If there is no waiting threads or all waiting threads have lower priority then current thread can continue its execution.
         * If there is waiting threads with same priority then we cannot guarantee which thread will get chance, it depends on mercy of Thread Scheduler.
         * If the remaining waiting threads are of same priority then we cannot guarantee when will the yielded thread will continue its execution.
         */
        Thread.currentThread().setName("mainThread");
        System.out.println(Thread.currentThread().getName() + " starts execution");

        Thread longTimeRunningThread = new Thread (() -> {
            System.out.println(Thread.currentThread().getName() + " starts execution");
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " executing....");
                Thread.yield();
            }
            System.out.println(Thread.currentThread().getName() + " completes execution");
        }, "longTimeRunningThread");

        longTimeRunningThread.start();

        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " executing....");
        }
        System.out.println(Thread.currentThread().getName() + " completes execution");
    }
}
