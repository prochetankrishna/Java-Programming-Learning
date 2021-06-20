package multithreading.interThreadCommunication;

class SumCalculator extends Thread {

    int total = 0;

    @Override
    public void run() {
        System.out.println("Child Thread starts calculation");
        for (int i = 1; i <= 100; i++) {
            total += i;
        }
        System.out.println("Child Thread completes calculation");
        synchronized (this) {
            System.out.println("Child Thread notifying waiting thread to resume operations");
            this.notify();
        }
    }
}

public class SumCalculatorThreadCommunicationExample {

    public static void main(String[] args) {

        SumCalculator sumCalculatorThread = new SumCalculator();
        sumCalculatorThread.start();

        synchronized (sumCalculatorThread) {
            try {
                System.out.println("Main Thread waiting for calculation to finish");
                sumCalculatorThread.wait();
                System.out.println("Main Thread resumes its operation");
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
        System.out.println(sumCalculatorThread.total);
    }
}
