package concurrency.threadgroup;

class ChildThread extends Thread{

    ChildThread(ThreadGroup threadGroup, String threadName) {
        super(threadGroup, threadName);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(4000);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }
}

public class ThreadGroupMethodExample {

    public static void main(String[] args) {

        ThreadGroup parentThreadGroup = new ThreadGroup("Parent-Thread-Group");
        ThreadGroup childThreadGroup = new ThreadGroup(parentThreadGroup, "Child-Thread-Group");

        ChildThread childThreadOne = new ChildThread(parentThreadGroup, "child-thread-one");
        ChildThread childThreadTwo = new ChildThread(parentThreadGroup, "child-thread-two");
        childThreadOne.start();
        childThreadTwo.start();

        System.out.println("Active Thread in Parent Thread Group : " + parentThreadGroup.activeCount());
        System.out.println("Active Thread Group in Parent Thread Group : " + parentThreadGroup.activeGroupCount());
        parentThreadGroup.list();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }

        System.out.println("Active Thread in Parent Thread Group : " + parentThreadGroup.activeCount());
        System.out.println("Active Thread Group in Parent Thread Group : " + parentThreadGroup.activeGroupCount());
        parentThreadGroup.list();
    }

}
