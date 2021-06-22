package concurrency.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

class PrinterThread extends Thread {

    static ReentrantLock reentrantLock = new ReentrantLock();

    PrinterThread (String threadName) {
        super(threadName);
    }

    @Override
    public void run() {

        if (reentrantLock.tryLock()) {
            System.out.println(Thread.currentThread().getName() + " got lock and now performing safe operations");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            reentrantLock.unlock();
        } else {
            System.out.println(Thread.currentThread().getName() + " unable to get lock and now performing alternative operations");
        }
    }
}

public class ReentrantTryLockExample {

    public static void main(String[] args) {

        PrinterThread printerThreadOne = new PrinterThread("printer-thread-one");
        PrinterThread printerThreadTwo = new PrinterThread("printer-thread-two");

        printerThreadOne.start();
        printerThreadTwo.start();
    }
}
