package multithreading.deadlock;

class A {

    public synchronized void doASpecificOperationWRTB(B b) {
        System.out.println(Thread.currentThread().getName() + " starts execution of method::doASpecificOperationWRTB()");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " trying to call B::method::doSomething()");
        b.doSomething();
    }

    public synchronized void doSomething() {
        System.out.println("Inside A::doSomething()");
    }
}

class B {

    public synchronized void doBSpecificOperationWRTA(A a) {
        System.out.println(Thread.currentThread().getName() + " starts execution of method::doBSpecificOperationWRTA()");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " trying to call A::method::doSomething()");
        a.doSomething();
    }

    public synchronized void doSomething() {
        System.out.println("Inside B::doSomething()");
    }
}

class ExecutionThread extends Thread {

    A a = new A();
    B b = new B();

    public void createDeadlock() {
        this.start();
        a.doASpecificOperationWRTB(b);  //Main-Thread
    }
    @Override
    public void run() {
        b.doBSpecificOperationWRTA(a); //Child-Thread
    }
}

public class DeadLockUsingLockExample {

    public static void main(String[] args) {
        Thread.currentThread().setName("Main-Thread");
        ExecutionThread executionThread = new ExecutionThread();
        executionThread.setName("Child-Thread");
        executionThread.createDeadlock();
    }
}
