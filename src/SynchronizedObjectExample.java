class Lock {

}

class PrintNumberThread extends Thread{

    Lock lock;

    PrintNumberThread (Lock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
        synchronized (lock) {
            for (int i = 1; i <= 3; i++) {
                System.out.println(Thread.currentThread().getName() + " : [SYNCHRONIZED] : " + i);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
        }
        for (int i = 1; i <= 3; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }
}

public class SynchronizedObjectExample {

    public static void main(String[] args) {

        Lock lock = new Lock();

        PrintNumberThread printNumberThreadOne = new PrintNumberThread(lock);
        printNumberThreadOne.setName("Print-Number-Thread-One");

        PrintNumberThread printNumberThreadTwo = new PrintNumberThread(lock);
        printNumberThreadTwo.setName("Print-Number-Thread-Two");

        printNumberThreadOne.start();
        printNumberThreadTwo.start();
    }
}
