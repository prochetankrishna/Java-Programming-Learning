package basicMultiThreading;

public class ThreadNameExample {

    public static void main(String[] args) {

        Thread childThreadDefaultName = new Thread (() -> {
            System.out.println("Child Thread Default Name: " + Thread.currentThread().getName());
        });

        System.out.println("Main Thread Default Name : " + Thread.currentThread().getName()); //By Default "main"
        childThreadDefaultName.start();

        Thread childThreadWithName = new Thread (() -> {
            System.out.println("Child Thread Name: " + Thread.currentThread().getName());
        }, "Long-Int-Panda");
        childThreadWithName.start();

        //Changing Name of Main Thread
        Thread.currentThread().setName("HertzBit");
        System.out.println("Main Thread Name : " + Thread.currentThread().getName());
    }
}
