package concurrency.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

class Greetings {

    ReentrantLock reentrantLock = new ReentrantLock();

    public void greet(String personName) {

        reentrantLock.lock();
        for (int i = 0; i < 10; i++) {
            System.out.print("Good Morning : ");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            System.out.println(personName);
        }
        reentrantLock.unlock();
    }
}

class GreetingsThread extends Thread {

    Greetings greetings;
    String personName;

    GreetingsThread (Greetings greetings, String personName) {
        this.greetings = greetings;
        this.personName = personName;
    }

    @Override
    public void run () {
        this.greetings.greet(this.personName);
    }
}

public class ReentrantLockExample {

    public static void main(String[] args) {
        Greetings greetings  = new Greetings();
        GreetingsThread greetingsThreadChetan = new GreetingsThread(greetings, "Chetan");
        GreetingsThread greetingsThreadChanchal = new GreetingsThread(greetings, "Chanchal");
        greetingsThreadChetan.start();
        greetingsThreadChanchal.start();
    }
}
