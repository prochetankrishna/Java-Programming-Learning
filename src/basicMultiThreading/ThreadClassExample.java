package basicMultiThreading;

class PrinterThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Hello from Printer Thread");
        }
    }
}

class DisplayThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Hello from Display Thread");
        }
    }
}

public class ThreadClassExample {

    public static void main(String[] args) {
        PrinterThread printerThread = new PrinterThread();
        printerThread.start();


        Thread displayThread = new Thread(new DisplayThread());
        displayThread.start();
        //displayThread.start(); //Runtime Exception : IllegalThreadStateException
    }
}
