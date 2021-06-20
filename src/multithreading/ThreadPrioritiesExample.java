package multithreading;

//Not Guaranteed
public class ThreadPrioritiesExample {

    public static void main(String[] args) {

        //Default Priority thread for only main thread is '5', but for all remaining threads default priority will be inherited from parent to child.
        Thread.currentThread().setPriority(9); //[Setting 'main' thread priority to 9

        Thread minPriorityThread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " executing with Priority : " + Thread.currentThread().getPriority());
        }, "minPriorityThread");
        minPriorityThread.setPriority(Thread.MIN_PRIORITY);

        Thread normPriorityThread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " executing with Priority : " + Thread.currentThread().getPriority());
        }, "normPriorityThread");
        normPriorityThread.setPriority(Thread.NORM_PRIORITY);

        Thread maxPriorityThread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " executing with Priority : " + Thread.currentThread().getPriority());
        }, "maxPriorityThread");
        maxPriorityThread.setPriority(Thread.MAX_PRIORITY);

        Thread customPriorityThread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " executing with Priority : " + Thread.currentThread().getPriority());
        }, "customPriorityThread");
        maxPriorityThread.setPriority(7); //Value should be in range 1-10 otherwise IllegalArgumentException

        Thread defaultPriorityThread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " executing with Priority : " + Thread.currentThread().getPriority());
        }, "defaultPriorityThread");

        //If 2 threads having same priority then we can't expect execution order. It depends on Thread Scheduler
        minPriorityThread.start();
        normPriorityThread.start();
        customPriorityThread.start();
        maxPriorityThread.start();
        defaultPriorityThread.start();

    }
}
