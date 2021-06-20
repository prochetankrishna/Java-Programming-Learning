package multithreading.interrupt;

public class InterruptExample2 {

    public static void main(String[] args) {

        System.out.println("Main Thread starts Execution");

        Thread lazyThread = new Thread(() -> {
            try {
                for (int i = 1; i <= 100000; i++) {
                    System.out.println(Thread.currentThread().getName() + " executing");
                }
                System.out.println(Thread.currentThread().getName() + " is going to sleep");
                Thread.sleep(2000);
            }catch (InterruptedException interruptedException) {
                System.out.println(Thread.currentThread().getName()  + " got interrupted.");
            }
        }, "lazyThread");

        lazyThread.start();
        lazyThread.interrupt();
        //Wait forever till thread goes to sleep. If thread is executing no effect of interrupt call till it gets into sleep.
        //Interrupt call never gets wasted, except the thread never goes to sleep/waiting in its lifetime.
        System.out.println("Main Thread completes Execution");
    }
}
