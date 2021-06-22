package concurrency.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockMethodExample {

    public static void main(String[] args) {

        //Constructors
        //ReentrantLock reentrantLock = new ReentrantLock();
        //ReentrantLock reentrantLock = new ReentrantLock(boolean fairness);
        //If 'fairness' is true, longest waiting thread will get the chance
        //Default value for 'fairness' is false, we don't know which waiting thread will get chance

        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock(); //Main Thread takes the lock
        reentrantLock.lock();

        System.out.println("Hold Count of Lock " + reentrantLock.getHoldCount());
        System.out.println("Is Lock occupied ? : " + reentrantLock.isLocked());
        System.out.println("Is Lock held by current thread ? : " + reentrantLock.isHeldByCurrentThread());
        System.out.println("Total thread(s) are waiting for this lock in waiting queue : " + reentrantLock.getQueueLength());

        reentrantLock.unlock();
        System.out.println("Hold Count of Lock " + reentrantLock.getHoldCount());
        System.out.println("Is Lock occupied ? : " + reentrantLock.isLocked());

        reentrantLock.unlock();
        System.out.println("Hold Count of Lock " + reentrantLock.getHoldCount());
        System.out.println("Is Lock occupied ? : " + reentrantLock.isLocked());
        System.out.println("Is Lock Fair ? : " + reentrantLock.isFair());
    }
}
