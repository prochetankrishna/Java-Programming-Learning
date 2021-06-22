package concurrency.reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class DatabaseThread extends Thread {

    static ReentrantLock reentrantLock = new ReentrantLock();

    DatabaseThread (String threadName) {
        super(threadName);
    }

    @Override
    public void run() {

        do {
            try {
                if (reentrantLock.tryLock(5000, TimeUnit.MILLISECONDS)) {
                    System.out.println(Thread.currentThread().getName() + " got the lock and performing DB update");
                    Thread.sleep(30000);
                    System.out.println(Thread.currentThread().getName() + " completes DB update and releases lock");
                    reentrantLock.unlock();
                    break;
                } else {
                    System.out.println(Thread.currentThread().getName() + " couldn't get the lock will try again after 5 seconds");
                }
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }while (true);
    }
}
public class ReentrantLockTryLockWithWaitExample {

    public static void main(String[] args) {

        DatabaseThread databaseThreadMongo = new DatabaseThread("mongo-database-thread");
        DatabaseThread databaseThreadMySQL = new DatabaseThread("mySQL-database-thread");

        databaseThreadMongo.start();
        databaseThreadMySQL.start();
    }
}
