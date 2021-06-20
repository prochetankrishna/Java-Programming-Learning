package basicMultiThreading.deadlock;

class ChildThread extends Thread {

    Thread mainThread;

    public ChildThread (Thread mainThread) {
        this.mainThread = mainThread;
    }

    @Override
    public void run() {

        try {
            mainThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("Child Thread");
        }
    }
}

public class DeadLockExample {

    public static void main(String[] args) {

        Thread mainThread = Thread.currentThread();
        ChildThread childThread = new ChildThread(mainThread);

        childThread.start();
        try {
            childThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 10 ; i++) {
            System.out.println("Main Thread");
        }
    }
}
