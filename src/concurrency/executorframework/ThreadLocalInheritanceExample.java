package concurrency.executorframework;

class ParentThread extends Thread {

    public static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    public static InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();

    @Override
    public void run () {
        threadLocal.set("PARENT");
        inheritableThreadLocal.set("PARENT");
        System.out.println("Parent Thread Local Value : " + threadLocal.get());
        System.out.println("Parent Inheritable Thread Local Value : " + inheritableThreadLocal.get());
        ChildThread childThread = new ChildThread();
        childThread.start();
    }
}

class ChildThread extends Thread {

    @Override
    public void run () {
        System.out.println("Child Thread Local Value : " + ParentThread.threadLocal.get());
        System.out.println("Child Inheritable Thread Local Value : " + ParentThread.inheritableThreadLocal.get());
    }
}

public class ThreadLocalInheritanceExample {

    public static void main(String[] args) {
        ParentThread parentThread = new ParentThread();
        parentThread.start();
    }
}
