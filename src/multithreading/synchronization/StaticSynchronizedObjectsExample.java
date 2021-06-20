package multithreading.synchronization;

class GreetDisplayStaticObject {

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

class GreetDisplayStaticObjectThread extends Thread {

    GreetDisplayStaticObject greetDisplayStaticObject;
    String personName;

    GreetDisplayStaticObjectThread (GreetDisplayStaticObject greetDisplayStaticObject, String personName) {
        this.greetDisplayStaticObject = greetDisplayStaticObject;
        this.personName = personName;
    }

    @Override
    public void run() {
        this.greetDisplayStaticObject.wish(this.personName);
    }
}

public class StaticSynchronizedObjectsExample {

    public static void main(String[] args) {

        GreetDisplayStaticObject greetDisplayStaticObjectChetan = new GreetDisplayStaticObject();
        GreetDisplayStaticObject greetDisplayStaticObjectChanchal = new GreetDisplayStaticObject();

        GreetDisplayStaticObjectThread greetDisplayStaticObjectThreadChetan = new GreetDisplayStaticObjectThread(greetDisplayStaticObjectChetan,"Chetan Krishna");
        greetDisplayStaticObjectThreadChetan.start();

        GreetDisplayStaticObjectThread greetDisplayStaticObjectThreadChanchal = new GreetDisplayStaticObjectThread(greetDisplayStaticObjectChanchal, "Chanchal Krishna");
        greetDisplayStaticObjectThreadChanchal.start();
    }
}
