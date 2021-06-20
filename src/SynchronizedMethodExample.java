class GreetDisplayM {

    public synchronized void wish (String personName) {
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

class GreetDisplayThreadM extends Thread {

    GreetDisplayM greetDisplayM;
    String personName;

    GreetDisplayThreadM (GreetDisplayM greetDisplayM, String personName) {
        this.greetDisplayM = greetDisplayM;
        this.personName = personName;
    }

    @Override
    public void run() {
        this.greetDisplayM.wish(this.personName);
    }
}

public class SynchronizedMethodExample {

    public static void main(String[] args) {
        GreetDisplayM greetDisplayM = new GreetDisplayM();

        GreetDisplayThreadM greetDisplayThreadChetanM = new GreetDisplayThreadM(greetDisplayM, "Chetan Krishna");
        greetDisplayThreadChetanM.start();

        GreetDisplayThreadM greetDisplayThreadChanchalM = new GreetDisplayThreadM(greetDisplayM, "Chanchal Krishna");
        greetDisplayThreadChanchalM.start();
    }
}
