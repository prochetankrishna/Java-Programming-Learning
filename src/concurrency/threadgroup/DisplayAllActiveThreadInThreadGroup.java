package concurrency.threadgroup;

public class DisplayAllActiveThreadInThreadGroup {

    public static void main(String[] args) {

        ThreadGroup systemThreadGroup = Thread.currentThread().getThreadGroup().getParent();
        Thread[] allActiveThreads = new Thread[systemThreadGroup.activeCount()];
        systemThreadGroup.enumerate(allActiveThreads);

        for (Thread eachThread : allActiveThreads) {
            System.out.println(eachThread.getName() + " is Daemon ? : " + eachThread.isDaemon());
        }
    }
}
