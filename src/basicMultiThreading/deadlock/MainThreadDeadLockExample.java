package basicMultiThreading.deadlock;

public class MainThreadDeadLockExample {

    public static void main(String[] args) {

        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
