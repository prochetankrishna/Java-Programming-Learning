package java8.methodReferences;

class Printer {

    public static void print() {

        for (int i = 0; i < 10; i++) {
            System.out.println(i + 1);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadUsingMethodReferences {

    public static void main(String[] args) {

        //Runnable runnable = Printer::print;
        //Thread thread = new Thread(runnable);
        //thread.start();

        new Thread(Printer::print).start();
    }
}
