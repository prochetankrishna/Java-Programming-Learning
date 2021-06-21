package multithreading;

class DaemonThread extends Thread {

    @Override
    public void run() {
        System.out.println("Is " + Thread.currentThread().getName() + " daemon ? : " + Thread.currentThread().isDaemon());
    }
}

class PrinterDaemonThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName() + " : [" + i + "]");
        }
    }
}

public class DaemonThreadExample {

    //Daemon nature can be set before start of thread.
    //Daemon nature is inherited from parent thread to child thread.
    //Daemon nature of main thread cannot be changed.

    public static void main(String[] args) {

        System.out.println("Start of Main Thread");
        System.out.println("Is " + Thread.currentThread().getName() + " daemon ? : " + Thread.currentThread().isDaemon());
        DaemonThread daemonThread_1 = new DaemonThread();
        daemonThread_1.setName("daemonThread-1");
        daemonThread_1.start();

        DaemonThread daemonThread_2 = new DaemonThread();
        daemonThread_2.setName("daemonThread-2");
        daemonThread_2.setDaemon(true);
        daemonThread_2.start();

        PrinterDaemonThread printerDaemonThread = new PrinterDaemonThread();
        printerDaemonThread.setDaemon(true);
        printerDaemonThread.setName("printerDaemonThread");
        printerDaemonThread.start();

        System.out.println("End Of Main Thread");
    }
}
