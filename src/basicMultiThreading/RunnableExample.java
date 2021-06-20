package basicMultiThreading;

class PrinterRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Hello from Printer Thread");
        }
    }
}

public class RunnableExample {

    public static void main(String[] args) {

        PrinterRunnable printerRunnable = new PrinterRunnable();
        Thread printerThread = new Thread(printerRunnable);
        printerThread.start();

        //Using Lambda
        Thread drawingThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Hello from Drawer Thread");
            }
        });
        drawingThread.start();

        //Anonymous Class
        Thread displayThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Hello from Display Thread");
                }
            }
        });
        displayThread.start();
    }

}
