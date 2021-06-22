package concurrency.threadgroup;

public class MainThreadGroupExample {

    public static void main(String[] args) {

        System.out.println("Main Thread's Thread Group : " + Thread.currentThread().getThreadGroup().getName());
        System.out.println("Main Thread Group's Parent : " + Thread.currentThread().getThreadGroup().getParent().getName());
    }
}
