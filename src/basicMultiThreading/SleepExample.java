package basicMultiThreading;

public class SleepExample {

    public static void main(String[] args) {

        for (int i = 1; i <= 10; i++) {
            System.out.println("Displaying Slide : " + i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
