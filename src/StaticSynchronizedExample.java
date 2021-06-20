class GreetDisplayStatic {

    public static synchronized void wish(String personName) {
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

class GreetDisplayStaticThread extends Thread {

    String personName;

    GreetDisplayStaticThread(String personName) {
        this.personName = personName;
    }

    @Override
    public void run() {
        GreetDisplayStatic.wish(this.personName);
    }
}

public class StaticSynchronizedExample {

    public static void main(String[] args) {
        GreetDisplayStaticThread greetDisplayStaticThreadChetan = new GreetDisplayStaticThread("Chetan Krishna");
        greetDisplayStaticThreadChetan.start();

        GreetDisplayStaticThread greetDisplayStaticThreadChanchal = new GreetDisplayStaticThread("Chanchal Krishna");
        greetDisplayStaticThreadChanchal.start();
    }
}
