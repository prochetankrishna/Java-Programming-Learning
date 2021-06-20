package basicMultiThreading.interrupt;

public class InterruptExample {

    public static void main(String[] args) {

        Thread lazyThread = new Thread(() -> {

            try {
                for (int i = 1; i <= 10; i++) {
                    System.out.println(Thread.currentThread().getName() + " executing");
                    Thread.sleep(2000);
                }
            }catch (InterruptedException interruptedException) {
                System.out.println(Thread.currentThread().getName()  + " got interrupted.");
            }
        }, "lazyThread");

        lazyThread.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }

        lazyThread.interrupt();
    }
}
