package multithreading.synchronization;

class GreetDisplayB {

    public void wish (String personName) {
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                System.out.print("Good Morning : ");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                System.out.println(personName);
            }
        }
    }
}

class GreetDisplayThreadB extends Thread {

    GreetDisplayB greetDisplayB;
    String personName;

    GreetDisplayThreadB (GreetDisplayB greetDisplayB, String personName) {
        this.greetDisplayB = greetDisplayB;
        this.personName = personName;
    }

    @Override
    public void run() {
        this.greetDisplayB.wish(this.personName);
    }
}

public class SynchronizedBlockExample {

    public static void main(String[] args) {
        GreetDisplayB greetDisplayB = new GreetDisplayB();

        GreetDisplayThreadB greetDisplayThreadChetanB = new GreetDisplayThreadB(greetDisplayB, "Chetan Krishna");
        greetDisplayThreadChetanB.start();

        GreetDisplayThreadB greetDisplayThreadChanchalB = new GreetDisplayThreadB(greetDisplayB, "Chanchal Krishna");
        greetDisplayThreadChanchalB.start();
    }
}
